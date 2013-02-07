package edu.wayne.cs.raptor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

/**
 * This unadulterated, no-holds-barred titan of a class takes care of saving and retrieval for 
 * patient, vitals, encounter, and pharmacy encounters.  like a boss. 
 * @author Jackson Turner, Ramez Habib
 *
 */


//TODO: catch errors on insert (at least for duplicate primary keys) and report to msg box
public class EncounterService implements IEncounterService {

	private Session userSession;
	private LoginBean login;
	private Calendar calendar;
	
	private int computerID;
	
	private Patient patient;
	private int patientID;
	private Encounter encounter;
	private Vitals vitals;
	//nobody cares about VitalsID but vitals.  *tiny violin*
	
	private boolean errorPreventedInsert = false;
	
	private String searchPatientId;
	private String searchPatientLastName;
	private String searchPatientFirstName;
	private List<Encounter> searchList;
	private List<Patient> patientList;
	private boolean newEncounter;
	
	public EncounterService() {
		patient = new Patient();
		encounter = new Encounter();
		vitals = new Vitals();
		calendar = Calendar.getInstance();
		searchList = new ArrayList<Encounter>();
		patientList = new ArrayList<Patient>();
		newEncounter = false;
	}
	
	public String saveOrUpdateEncounter()
	{
		if(patient.getPatientID()!=0)
			return updateEncounter();
		return saveNewEncounter();
		
	}
	
	public String updateEncounter()
	{
		//housekeeping
		patient.setModifyingUser(login.getSystemUser().getUsername());
		patient.setLastModifiedDate(calendar.getTime());
		
		vitals.setCreatingUser(login.getSystemUser().getUsername());
		vitals.setCreatedDate(calendar.getTime());
		vitals.setModifyingUser(login.getSystemUser().getUsername());
		vitals.setLastModifiedDate(calendar.getTime());
		
		encounter.setCreatingUser(login.getSystemUser().getUsername());
		encounter.setCreatedDate(calendar.getTime());
		encounter.setModifyingUser(login.getSystemUser().getUsername());
		encounter.setLastModifiedDate(calendar.getTime());
		  
		//get it right the first time.  no cheating. 
		//end housekeeping
		
		try
		{
			userSession = HibernateUtil.getSessionFactory().openSession();
			userSession.beginTransaction();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error in opening session or transaction. " + ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			errorPreventedInsert = true;
		}
		
		try
		{
			//TODO:there is a bug after a failed insert (dupe blood sample) where the user id remains and leads to an attempted update of the patient which does not yet exist in db --> leads to timeout.  
			userSession.update(patient);
			encounter.setPatientID(this.patient.getPatientID());
			vitals.setVitalsID(encounter.getEncounterID());
			userSession.save(encounter);
			vitals.setEncounterID(this.encounter.getEncounterID());
			userSession.save(vitals);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error in saving record. " + ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			errorPreventedInsert = true;
		}	
		
		try
		{
			userSession.getTransaction().commit();
			userSession.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error in committing transaction or closing session. " + ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			errorPreventedInsert = true;
		}
		
		if(errorPreventedInsert == false)
		{
			JOptionPane.showMessageDialog(null, "Record saved!", "Success!", JOptionPane.INFORMATION_MESSAGE);

			patient = new Patient();
			vitals = new Vitals();
			encounter = new Encounter();
			
			//return "create" to go back to create.jsp after the create patient form is submitted
			return "create";
		}
		errorPreventedInsert = false;
		return null;
	}
	
	public String saveNewEncounter()
	{
		//housekeeping
		patient.setCreatingUser(login.getSystemUser().getUsername());
		patient.setCreatedDate(calendar.getTime());
		patient.setModifyingUser(login.getSystemUser().getUsername());
		patient.setLastModifiedDate(calendar.getTime());
		
		vitals.setCreatingUser(login.getSystemUser().getUsername());
		vitals.setCreatedDate(calendar.getTime());
		vitals.setModifyingUser(login.getSystemUser().getUsername());
		vitals.setLastModifiedDate(calendar.getTime());
		
		encounter.setCreatingUser(login.getSystemUser().getUsername());
		encounter.setCreatedDate(calendar.getTime());
		encounter.setModifyingUser(login.getSystemUser().getUsername());
		encounter.setLastModifiedDate(calendar.getTime());
		//end housekeeping
		
		determinePatientID();
		
		try
		{
			userSession = HibernateUtil.getSessionFactory().openSession();
			userSession.beginTransaction();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error in opening session or transaction. " + ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			errorPreventedInsert = true;
		}
		
		try
		{
			
			//get the patientID once its saved and use it for encounter
			patientID = (Integer)userSession.save(patient);
			encounter.setPatientID(patientID);
			//Really? there's a vitalsID too? Really?
			vitals.setVitalsID(encounter.getEncounterID());
			//Yeah really, and now it's set to be the same as encounterID
			

			//get the encounterID once it is saved and use it in vitals
			userSession.save(encounter);
			vitals.setEncounterID(this.encounter.getEncounterID());
			
			userSession.save(vitals);
		}
		
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error in saving record. " + ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			errorPreventedInsert = true;
		}	
		
		try
		{
			userSession.getTransaction().commit();
			userSession.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error in committing transaction or closing session. " + ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			errorPreventedInsert = true;
		}
		
		if(errorPreventedInsert == false)
		{
			JOptionPane.showMessageDialog(null, "Record saved!", "Success!", JOptionPane.INFORMATION_MESSAGE);

			patient = new Patient();
			vitals = new Vitals();
			encounter = new Encounter();
			
			//return "create" to go back to create.jsp after the create patient form is submitted
			return "create";
		}
		errorPreventedInsert = false;
		return null;
		
	}

	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public void setEncounter(Encounter encounter)
	{
		this.encounter = encounter;
	}
	public Encounter getEncounter()
	{
		return encounter;
	}
	
	public Vitals getVitals() {
		return vitals;
	}
	public void setVitals(Vitals vitals) {
		this.vitals = vitals;
	}
	
	public void setLogin(LoginBean login) {
		this.login = login;
	}
	public LoginBean getLogin()
	{
		return login;
	}
		
	public String getSearchPatientId() {
		return searchPatientId;
	}
	public void setSearchPatientId(String searchPatientId) {
		this.searchPatientId = searchPatientId;
	}

	public String getSearchPatientLastName() {
		return searchPatientLastName;
	}

	public void setSearchPatientLastName(String searchPatientLastName) {
		this.searchPatientLastName = searchPatientLastName;
	}

	public String getSearchPatientFirstName() {
		return searchPatientFirstName;
	}

	public void setSearchPatientFirstName(String searchPatientFirstName) {
		this.searchPatientFirstName = searchPatientFirstName;
	}

	public List<Encounter> getSearchList() {
		return searchList;
	}
	public void setSearchList(List<Encounter> searchList) {
		this.searchList = searchList;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public boolean isNewEncounter() {
		return newEncounter;
	}
	public void setNewEncounter(boolean newEncounter) {
		this.newEncounter = newEncounter;
	}

	/**Method called when search button is clicked, takes you to 
	 *  table with the list of prev. encounters for the patient, 
	 *  select an Encounter, view its info. 
	 *  Then start a new encounter 
	 *
	 */
	public String searchPatient(){
		
		int tempPId =0;
		if(!this.searchPatientId.isEmpty())
		{
			tempPId = Integer.parseInt(this.searchPatientId);
			this.patient = getPatient(tempPId);
		}
		if(tempPId >0 )
			this.searchList = getAllEncounters(tempPId);
		
		this.searchPatientId = "";
		this.searchPatientFirstName = "";
		this.searchPatientLastName = "";
		
		return "searchPage";
	}
	
	public String searchPatients()
	{
		String tempLastName = "";
		if(!this.searchPatientLastName.isEmpty())
		{
			tempLastName = this.searchPatientLastName;
		}
		
		if(tempLastName != "")
		{
			this.patientList = getAllPatientsByName(tempLastName);
		}
		
		this.searchPatientId = "";
		this.searchPatientFirstName = "";
		this.searchPatientLastName = "";
		
		return "patientSearch";
	}
	
	public String searchPatientsF()
	{
		String tempFirstName ="";
		if(!this.searchPatientFirstName.isEmpty())
		{
			tempFirstName = this.searchPatientFirstName;
		}
		
		if(tempFirstName != "")
		{
			this.patientList = getAllPatientsByFName(tempFirstName);
		}
		
		this.searchPatientId = "";
		this.searchPatientFirstName = "";
		this.searchPatientLastName = "";
		
		return "patientSearch";
	}
	
	/** Select an encounter from the list of Ecnounters retrieved by searching for the patient  */
	public String selectEncounter(){
		
		// Populate the fields of vitals that belong to that encounter 
		vitals = getVitalsByEncounter(encounter.getEncounterID());
		setNewEncounter(true);
		return "create";
	}
	
	public String selectPatient(){
		
		//populate fields of patient...or something. 
		this.searchList = getAllEncounters(patient.getPatientID());
		return "searchPage";
	}
	
	private Vitals getVitalsByEncounter(int encounterID2) {
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Vitals> result = userSession.createQuery("from Vitals where encounterID = '" +encounterID2+ "' ").list();
		
		userSession.getTransaction().commit();
		userSession.close();
		if(!result.isEmpty())
			return result.get(0);
		return null;
	}

	/** Start a new Encounter after searching for a patient and viewing an encounter for them */
	public String startEncounter(){
		vitals = new Vitals();
		encounter = new Encounter();
		setNewEncounter(false);
		return "create";
		
	}
	
	public String resetRecord(){
		setNewEncounter(false);
		patient = new Patient();
		encounter = new Encounter();
		vitals = new Vitals();
		return "create";
	}
	
	/***********************************/
	/****** Patient Operations ********/
    /*********************************/

	@Override
	public void savePatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	/**TODO: when searching for patient, Need to decide if we also populate the form with latest encounter or 
	 *       get a list of all previous encounters and display that , then once an encounter is 
	 *       clicked populate a form ( just output ) 
	 * */ 
	@Override
	public Patient getPatient(int patientId) {
	
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Patient> result = userSession.createQuery("from Patient where patientID='" + patientId + "'").list();
		userSession.getTransaction().commit();
		userSession.close();
		

		if (!result.isEmpty() )
			return result.get(0);
		return null;
	}

	@Override
	/** this method might not be needed since it only returns the first patient out of a set 
	 *  of patients that exist in the system with the same last name
	 *  @see getAllPatientsByName(String)
	 * */
	public Patient getPatientByLastName(String lastName) {
		
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Patient> result = userSession.createQuery("from Patient where lastName='" + lastName + "'").list();
		userSession.getTransaction().commit();
		userSession.close();
		if (!result.isEmpty() )
			return result.get(0);
		return null;
	}

	/**
	 * TODO: When searching for a patient , only one patient is displayed if found
	 *       do we want to search for all patients with specific last name for example
	 *       or specific residence 
	 */
	@Override
	public List<Patient> getAllPatients() {
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Patient> result = userSession.createQuery("from Patient ").list();
		userSession.getTransaction().commit();
		userSession.close();
		
		if (!result.isEmpty() )
			return result;
		return null;
	}
	
	@Override
	public List<Patient> getAllPatientsByName(String lastName){
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Patient> result = userSession.createQuery("from Patient where lastName='" + lastName + "'").list();
		userSession.getTransaction().commit();
		userSession.close();
		if (!result.isEmpty() )
			return result;
		return null;
		
	}
	
	public List<Patient> getAllPatientsByFName(String firstName)
	{
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Patient> result = userSession.createQuery("from Patient where firstName='" + firstName + "'").list();
		userSession.getTransaction().commit();
		userSession.close();
		
		if(!result.isEmpty())
			return result;
		return null;
	}
	
	/***********************************/
	/****** Encounter Operations ******/
    /*********************************/
	
	
	@Override
	public void saveEncounter(Encounter encounter) {
		// TODO Auto-generated method stub
		
	} 

	@Override
	public Encounter getEncounter(int encounterId) {
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Encounter> result = userSession.createQuery("from Encounter where encounterID='" + encounterId + "'").list();
		userSession.getTransaction().commit();
		userSession.close();
		if (!result.isEmpty() )
			return result.get(0);
		return null;
	}

	@Override
	public Encounter getEncounterByPatient(int patientId) {
		
		return null;
	}

	@Override
	public Encounter getEncounterByPatientName(String patientName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Encounter> getAllEncounters(int patientId) {
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Encounter> result = userSession.createQuery("from Encounter where patientID='" + patientId + "'").list();
		userSession.getTransaction().commit();
		userSession.close();
		if (!result.isEmpty() )
			return result;
		return null;
	}
	
	public List<Patient> getAllPatients(int patientID)
	{
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Patient> result = userSession.createQuery("from Patients where patientID='" + patientID + "'").list();
		userSession.getTransaction().commit();
		userSession.close();
		if(!result.isEmpty())
			return result;
		return null; //LOLWUT. 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Encounter> getAllEncountersByName(String patientName) {
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		
		List<Patient> tempPatient = userSession.createQuery("from Patient where lastName='" + patientName + "'").list();
		int tempPatientId;
		List<Encounter> result = null;
		
		// Check if patient exists in the system first, thus list is not empty
		if(!tempPatient.isEmpty())
		{
			tempPatientId = tempPatient.get(0).getPatientID();
			result = userSession.createQuery("from Encounter where patientID='" + tempPatientId + "'").list();
			
		}
		
		userSession.getTransaction().commit();
		userSession.close();
		if (!result.isEmpty() )
			return result;
		return null;
	}
	
	//PatientID stuff
	public void determinePatientID(){
		int computerIDInitialValue = 0;
		int computerIDMaxValue = 1;
		
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Patient> patientList = userSession.createQuery("from Patient ").list();
		userSession.getTransaction().commit();
		userSession.close();
		
		setComputerID(this.login.getComputerID());
		
		computerIDInitialValue = computerID * 1000000;
		computerIDMaxValue = (computerID + 1) * 1000000;
		
		
		ArrayList<Integer> patientIDList = new ArrayList<Integer>();
		if(patientList.size() > 0){
			for(int i = 0; i < patientList.size(); i++) {
				patientIDList.add(patientList.get(i).getPatientID());
			}
			
			patient.setPatientID(beginningPatientID(patientIDList, computerIDInitialValue, computerIDMaxValue));
			
			//This code starts from highest encounterID in the DB table
			//Replacing this with code to choose next encounterID based on what's in DB and computerID
			/*for(int i = 0; i < pharmacyEncounterList.size(); i++) {
				encounterIDList.add(pharmacyEncounterList.get(i).getEncounterID());
			}
		
			encounterID = Collections.max(encounterIDList) + 1;*/
		}
		else
			patient.setPatientID(computerIDInitialValue);
	}
	
	public int beginningPatientID(ArrayList<Integer> patientIDList, int computerIDInitialValue,
			int computerIDMaxValue){
		
		boolean changedTempPatientID = false;
		int tempPatientID = computerIDInitialValue;
		
		// TODO: stop for loop if values go beyond computerIDMaxValue
		for(int i = 0; i < patientIDList.size(); i++){
			if((patientIDList.get(i) >= tempPatientID) && (patientIDList.get(i) < computerIDMaxValue)){
				tempPatientID = patientIDList.get(i);
				if(changedTempPatientID == false){
					changedTempPatientID = true;
				}
			}
		}
		
		if(changedTempPatientID == true){
			tempPatientID = tempPatientID + 1;
		}
		
		return tempPatientID;
	}

	public int getComputerID() {
		return computerID;
	}

	public void setComputerID(int computerID) {
		this.computerID = computerID;
	}


}