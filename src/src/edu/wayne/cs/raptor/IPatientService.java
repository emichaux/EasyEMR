package edu.wayne.cs.raptor;

import java.util.List;

/**
 * Interface containing methods that serve patient entities in the system
 * create/save patient in database search for patient by id, name . retrieve all
 * patients in the database possibly merge patients information when synchronizing ? 
 * (Need better description wording )
 * 
 * @author Ramez
 */

public interface IPatientService {

	public String savePatient();

	public Patient getPatient();

	public Patient getPatientByLast(String lastName);

	public List<Patient> getAllPatients();

	/** Could be split into last name and first name or use just last name */
	public List<Patient> getPatientsByName(String name);

	public List<Patient> getPatientsByResidence(String residence);
	
	

	/**
	 * TODO: Need Other Methods to search for patients based on identifiers or a
	 * combination of identifiers
	 */
	public List<Patient> getPatientsByIdentifier();

	public void mergePatients();

	Patient getPatientsByFirstName(String firstname);

}
