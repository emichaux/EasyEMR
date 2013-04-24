package edu.wayne.cs.raptor;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;

public class PatientService implements IPatientService {

	private LoginBean login;
	private Patient patient;
	private Patient newPatient;

	
	private String searchPatientID;  
	private String searchFirst;		
	private String searchLast;
	
	Session userSession;
	private Calendar calendar = Calendar.getInstance();
	
	
	private List<Patient> patientList;
	private boolean isCreating;

	
	public PatientService()
	{
		patient = new Patient();
	}
	
	public void setLogin(LoginBean login){
		this.login=login;
	}
	
	@Override
	public String savePatient() {
		patient.setCreatingUser(this.login.getSystemUser().getUsername());
		patient.setCreatedDate(calendar.getTime());
		patient.setModifyingUser(this.login.getSystemUser().getUsername());
		patient.setLastModifiedDate(calendar.getTime()); 
		
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
	
		userSession.save(patient);
		
		userSession.getTransaction().commit(); 
		userSession.close();
		patient = new Patient();
		return "create";
	}
	
	
	
public List<Patient> populateAllPatients() {
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Patient> result = userSession.createQuery( "from Patient" ).list();
		userSession.getTransaction().commit(); 
		userSession.close();
		
		if(!result.isEmpty())
			return result;
		else
			return null;
	}
	
public String displayAllPatients(){
	setPatientList(populateAllPatients());
	return null;
	}
	
public String searchPatientID()
{
	setCreating(false);
	if (!this.searchPatientID.isEmpty())
		if ( getPatientsByPatientID(this.searchPatientID)!=null )
			setNewPatient(getPatientsByPatientID(this.searchPatientID));			
	if(!this.searchLast.isEmpty())
		if ( getPatientByLast(this.searchLast)!=null )
				setNewPatient(getPatientByLast(this.searchLast));	
	if(!this.searchFirst.isEmpty())
		if ( getPatientsByFirstName(this.searchFirst)!=null )
			setNewPatient(getPatientsByFirstName(this.searchFirst));	
	return null;
}



public String resetFields(){
	setSearchFirst("");
	setSearchLast("");
	setCreating(true);
	setNewPatient(new Patient());
	return null;
}

public String selectPatient(){
	setCreating(false);
	return null;
}


	
	@Override
	public Patient getPatient() {
		return this.patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public Patient getPatientByLast(String lastName) {
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Patient> lastNameResult = userSession.createQuery("from User user where user.username='" + lastName + "'").list();
		userSession.getTransaction().commit();
		userSession.close();
		
		//this field should be unique in the DB as well, so the result list should contain only one record.  
		if(!lastNameResult.isEmpty())
			return lastNameResult.get(0);		
		else
			return null;
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return null ;
	}

	@Override
	public Patient getPatientsByFirstName(String firstname) {
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Patient> firstNameResult = userSession.createQuery("from User user where user.username='" + firstname + "'").list();
		userSession.getTransaction().commit();
		userSession.close();
		
		//this field should be unique in the DB as well, so the result list should contain only one record.  
		if(!firstNameResult.isEmpty())
			return firstNameResult.get(0);		
		else
			return null;
	}

public Patient getPatientsByPatientID(String patientID) {
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Patient> firstNameResult = userSession.createQuery("from User user where user.username='" + patientID + "'").list();
		userSession.getTransaction().commit();
		userSession.close();
		
		//this field should be unique in the DB as well, so the result list should contain only one record.  
		if(!firstNameResult.isEmpty())
			return firstNameResult.get(0);		
		else
			return null;
	}
	@Override
	public List<Patient> getPatientsByResidence(String residence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getPatientsByIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mergePatients() {
		// TODO Auto-generated method stub

	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public String getSearchPatientID() {
		return searchPatientID;
	}

	public void setSearchPatientID(String searchPatientID) {
		this.searchPatientID = searchPatientID;
	}

	public String getSearchFirst() {
		return searchFirst;
	}

	public void setSearchFirst(String searchFirst) {
		this.searchFirst = searchFirst;
	}

	public String getSearchLast() {
		return searchLast;
	}

	public void setSearchLast(String searchLast) {
		this.searchLast = searchLast;
	}

	@Override
	public List<Patient> getPatientsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isCreating() {
		return isCreating;
	}

	public void setCreating(boolean isCreating) {
		this.isCreating = isCreating;
	}

	public Patient getNewPatient() {
		return newPatient;
	}

	public void setNewPatient(Patient newPatient) {
		this.newPatient = newPatient;
	}

}
