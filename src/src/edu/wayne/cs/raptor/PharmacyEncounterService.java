package edu.wayne.cs.raptor;

import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

public class PharmacyEncounterService {
	
	//private int userID;
	private int computerID;
	//private int computerIDInitialValue;
	//private int computerIDMaxValue;

	protected int encounterID;
	private String firstName;
	private String lastName;
	protected String medDispensed1;
	protected String medDispensed2;
	protected String medDispensed3;
	protected String medDispensed4;
	protected String medDispensed5;
	protected boolean equalPrescribed1 = true;
	protected boolean equalPrescribed2 = true;
	protected boolean equalPrescribed3 = true;
	protected boolean equalPrescribed4 = true;
	protected boolean equalPrescribed5 = true;

	private LoginBean login;
	private Calendar calendar = Calendar.getInstance();

	private Session pharmSession;

	private PharmacyEncounter pharmEncounter;
	
	private String creationResult;
	private String recordIDInstruction;
	private String encounterIDText;

	public PharmacyEncounterService() {
		pharmEncounter = new PharmacyEncounter();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEncounterID() {
		return encounterID;
	}

	public void setEncounterID(int encounterID) {
		this.encounterID = encounterID;
	}

	public String getMedDispensed1() {
		return medDispensed1;
	}

	public void setMedDispensed1(String medDispensed1) {
		this.medDispensed1 = medDispensed1;
	}

	public String getMedDispensed2() {
		return medDispensed2;
	}

	public void setMedDispensed2(String medDispensed2) {
		this.medDispensed2 = medDispensed2;
	}

	public String getMedDispensed3() {
		return medDispensed3;
	}

	public void setMedDispensed3(String medDispensed3) {
		this.medDispensed3 = medDispensed3;
	}

	public boolean getEqualPrescribed1() {
		return equalPrescribed1;
	}

	public void setEqualPrescribed1(boolean equalPrescribed1) {
		this.equalPrescribed1 = equalPrescribed1;
	}

	public boolean getEqualPrescribed2() {
		return equalPrescribed2;
	}

	public void setEqualPrescribed2(boolean equalPrescribed2) {
		this.equalPrescribed2 = equalPrescribed2;
	}

	public boolean getEqualPrescribed3() {
		return equalPrescribed3;
	}

	public void setEqualPrescribed3(boolean equalPrescribed3) {
		this.equalPrescribed3 = equalPrescribed3;
	}

	public Session getPharmSession() {
		return pharmSession;
	}

	public void setPharmSession(Session pharmSession) {
		this.pharmSession = pharmSession;
	}

	public PharmacyEncounter getPharmEncounter() {
		return pharmEncounter;
	}

	public void setPharmEncounter(PharmacyEncounter pharmEncounter) {
		this.pharmEncounter = pharmEncounter;
	}

	public String getMedDispensed4() {
		return medDispensed4;
	}

	public void setMedDispensed4(String medDispensed4) {
		this.medDispensed4 = medDispensed4;
	}

	public String getMedDispensed5() {
		return medDispensed5;
	}

	public void setMedDispensed5(String medDispensed5) {
		this.medDispensed5 = medDispensed5;
	}

	public boolean getEqualPrescribed4() {
		return equalPrescribed4;
	}

	public void setEqualPrescribed4(boolean equalPrescribed4) {
		this.equalPrescribed4 = equalPrescribed4;
	}

	public boolean getEqualPrescribed5() {
		return equalPrescribed5;
	}

	public void setEqualPrescribed5(boolean equalPrescribed5) {
		this.equalPrescribed5 = equalPrescribed5;
	}

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public String getCreationResult() {
		return creationResult;
	}

	public void setCreationResult(String creationResult) {
		this.creationResult = creationResult;
	}

	public String getRecordIDInstruction() {
		return recordIDInstruction;
	}

	public void setRecordIDInstruction(String recordIDInstruction) {
		this.recordIDInstruction = recordIDInstruction;
	}

	//TODO: pad encounterID to always be 9 digits
	public String dataToDatabase() {	
		determineEncounterID();
		
		passToPharmEncounter();

		pharmSession = HibernateUtil.getSessionFactory().openSession();
		pharmSession.beginTransaction();
		encounterID = (Integer) pharmSession.save(pharmEncounter);
		pharmSession.getTransaction().commit();
		pharmSession.close();

		//creationResult = "Visit ID "+Integer.toString(encounterID)+" created.";
		
		JOptionPane.showMessageDialog(null, String.format("%09d", encounterID)+" created.");

		resetFields();

		return "Valid";
	}

	public void passToPharmEncounter(){
		pharmEncounter = new PharmacyEncounter(encounterID, firstName, lastName, medDispensed1, medDispensed2, 
				medDispensed3, medDispensed4, medDispensed5, equalPrescribed1, equalPrescribed2, equalPrescribed3, 
				equalPrescribed4, equalPrescribed5);

		pharmEncounter.setCreatingUser(this.login.getSystemUser().getUsername());
		pharmEncounter.setCreatedDate(calendar.getTime());
	}

	public void resetFields(){
		setEncounterID(encounterID + 1);
		
		setEncounterIDText("Visit ID: "+String.format("%09d", encounterID));
		setRecordIDInstruction("Write visit ID on patient sheet.");
		
		setFirstName(null);
		setLastName(null);
		
		setMedDispensed1(null);
		setMedDispensed2(null);
		setMedDispensed3(null);
		setMedDispensed4(null);
		setMedDispensed5(null);
		setEqualPrescribed1(true);
		setEqualPrescribed2(true);
		setEqualPrescribed3(true);
		setEqualPrescribed4(true);
		setEqualPrescribed5(true);
	}
	
	public int beginningEncounterID(ArrayList<Integer> encounterIDList, int computerIDInitialValue,
			int computerIDMaxValue){
		
		boolean changedTempEncounterID = false;
		int tempEncounterID = computerIDInitialValue;
		
		// TODO: stop for loop if values go beyond computerIDMaxValue
		for(int i = 0; i < encounterIDList.size(); i++){
			if((encounterIDList.get(i) >= tempEncounterID) && (encounterIDList.get(i) < computerIDMaxValue)){
				tempEncounterID = encounterIDList.get(i);
				if(changedTempEncounterID == false){
					changedTempEncounterID = true;
				}
			}
		}
		
		if(changedTempEncounterID == true){
			tempEncounterID = tempEncounterID + 1;
		}
		
		return tempEncounterID;
	}
	
	public void determineEncounterID(){
		int computerIDInitialValue = 0;
		int computerIDMaxValue = 1;
		
		pharmSession = HibernateUtil.getSessionFactory().openSession();
		pharmSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<PharmacyEncounter> pharmacyEncounterList = pharmSession.createQuery("from PharmacyEncounter ").list();
		pharmSession.getTransaction().commit();
		pharmSession.close();
		
		setComputerID(this.login.getComputerID());
		
		computerIDInitialValue = computerID * 1000000;
		computerIDMaxValue = (computerID + 1) * 1000000;
		
		
		ArrayList<Integer> encounterIDList = new ArrayList<Integer>();
		if(pharmacyEncounterList.size() > 0){
			for(int i = 0; i < pharmacyEncounterList.size(); i++) {
				encounterIDList.add(pharmacyEncounterList.get(i).getEncounterID());
			}
			
			setEncounterID(beginningEncounterID(encounterIDList, computerIDInitialValue, computerIDMaxValue));
			
			//This code starts from highest encounterID in the DB table
			//Replacing this with code to choose next encounterID based on what's in DB and computerID
			/*for(int i = 0; i < pharmacyEncounterList.size(); i++) {
				encounterIDList.add(pharmacyEncounterList.get(i).getEncounterID());
			}
		
			encounterID = Collections.max(encounterIDList) + 1;*/
		}
		else
			encounterID = computerIDInitialValue;
	}

	public int getComputerID() {
		return computerID;
	}

	public void setComputerID(int computerID) {
		this.computerID = computerID;
	}

	public String getEncounterIDText() {
		return encounterIDText;
	}

	public void setEncounterIDText(String encounterIDText) {
		this.encounterIDText = encounterIDText;
	}

	/*public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}*/

}