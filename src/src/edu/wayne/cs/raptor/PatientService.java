package edu.wayne.cs.raptor;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;

public class PatientService implements IPatientService {

	private LoginBean login;
	private Patient patient;
	Session userSession;
	private Calendar calendar = Calendar.getInstance();
	
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
	
	@Override
	public Patient getPatient() {
		return this.patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public Patient getPatientByLast(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getPatientsByName(String name) {
		// TODO Auto-generated method stub
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

}
