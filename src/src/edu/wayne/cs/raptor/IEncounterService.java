package edu.wayne.cs.raptor;

import java.util.List;

/** Should contain methods that save an encounter , retrieve encounters for a patient , etc
 * 
 *  @author Ramez
 *  */


public interface IEncounterService {

	/* Patient Operations */
	public void savePatient(Patient patient);  // this will save a patient 
												// call on save encounter if encounter is started for an existing 
	                                            // patient
	
	/** Returns a patient with the specified patientId */
	public Patient getPatient(int patientId);
	
	/** Returns a patient with the specified lastName */
	public Patient getPatientByLastName(String lastName);
	
	/** Returns all patients in the system */ 
	public List<Patient> getAllPatients();
	
	/** Returns all patients in the system with the specified lastName*/
	public List<Patient> getAllPatientsByName(String lastName);
	
	
	/* Encounter Operations */
	public void saveEncounter(Encounter encounter);
	
	/** Returns the encounter with the specified encounterId   */
	public Encounter getEncounter(int encounterId);
	
	public Encounter getEncounterByPatient(int patientId);
	public Encounter getEncounterByPatientName(String patientName);
	
	/** Returns all encounters for a patient with the specified patientId */
	public List<Encounter> getAllEncounters(int patientId);
	/** Returns all encounters for a patient with the specified last name ? */
	public List<Encounter> getAllEncountersByName(String patientName);
	
	
	
	

}
