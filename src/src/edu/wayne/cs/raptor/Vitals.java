package edu.wayne.cs.raptor;

import java.util.Date;

import javax.persistence.*;



/** The vitals of a patient during a specific encounter.
 * 
 * @author Ramez
 *
 */
@Entity
@Table (name = "VITALS")
public class Vitals {
	
	/* Should have a constraint on values ? */
	//TODO: figure out if we can even get doubles back from the front end.
	//scott mentioned everything comes through as strings because tomcat.  
	
	/** unique identifier of a set of vitals for the specific encounter */
	private int vitalsID;
	
	/** a set of vitals is identified by its encounter id number */
	private int encounterID;
	
	/** Card ID to create a better use case for a given patient */
	private String cardID;
	
	/** Patient's systolic blood pressure */
	private int systolicBP;
	
	/** Patient's diastolic blood pressure */
	private int diastolicBP;
	
	/** Patient's heart rate as BeatsPerMinute*/
	private int heartRate;
	
	/** Patient's respiratory rate */
	private int respRate;
	
	/** Patient's temperature in fahrenheit */
	private double temperatureF;
	
	/** Patient's pulse oximetry in percentage */
	private int oximetry;
	
	/** Patient had blood drawn */
	private boolean malaria;
	private boolean dengue;
	
	/** Patient's blood sample number */
	private int bloodSampleID;
	
	/** Patient's measured height */
	private int height;
	
	/** Patient's measured weight */
	private int weight;
	
	/** Patient's measured patientBMI */
	private int calculatedBMI;
	
	/** User that created this Vitals document */
	private String creatingUser;
	
	/** Date this vitals document was created */
	private Date createdDate;
	
	/** The user that last modified this vitals doc */
	private String modifyingUser;
	
	/** The date of the last modification to this vitals document */
	private Date lastModifiedDate;
	
	/** Default empty constructor */
	public Vitals(){	
		//assignment operator seems to work just fine (i asked jUnit, he said so)
	}
	
	@Id
	public int getVitalsID() {
		return vitalsID;
	}

	public void setVitalsID(int vitalsID) {
		this.vitalsID = vitalsID;
	}

	public int getEncounterID() {
		return encounterID;
	}

	public void setEncounterID(int encounterID) {
		this.encounterID = encounterID;
	}

	/** Returns patient's systolic blood pressure */
	public int getSystolicBP() {
		return systolicBP;
	}
	
	/** Sets patient's systolic blood pressure */
	public void setSystolicBP(int systolicBP) {
		this.systolicBP = systolicBP;
	}
	
	/** Returns patient's diastolic blood pressure */
	public int getDiastolicBP() {
		return diastolicBP;
	}
	
	/** Sets patient's diastolic blood pressure */
	public void setDiastolicBP(int diastolicBP) {
		this.diastolicBP = diastolicBP;
	}
	
	/** Returns patient's heart rate */
	public int getHeartRate() {
		return heartRate;
	}
	
	/** Sets the patient's heart rate */
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
	
	/** Returns patient's respiratory rate */
	public int getRespRate() {
		return respRate;
	}
	
	/** Sets the patient's repiratory rate */
	public void setRespRate(int respRate) {
		this.respRate = respRate;
	}
	
	/** Returns the patient's temperature */
	public double getTemperatureF() {
		return temperatureF;
	}
	
	/** Sets the patient's temperature */
	public void setTemperatureF(double temperatureF) {
		this.temperatureF = temperatureF;
	}
	
	/** Returns the patient's pulse oximetry */
	public int getOximetry() {
		return oximetry;
	}
	
	/** Sets the patient's pulse oximetry */
	public void setOximetry(int oximetry) {
		this.oximetry = oximetry;
	}
	
	public boolean getMalaria() {
		return malaria;
	}

	public void setMalaria(boolean malaria) {
		this.malaria = malaria;
	}

	public boolean getDengue() {
		return dengue;
	}

	public void setDengue(boolean dengue) {
		this.dengue = dengue;
	}

	/** Returns the patient's blood draw sample id number */
	public int getBloodSampleID() {
		return bloodSampleID;
	}
	
	/** Sets the patient's blood draw sample id number */
	public void setBloodSampleID(int bloodDrawID) {
		this.bloodSampleID = bloodDrawID;
	}
	
	/** Returns the patient's measured height */
	public int getHeight() {
		return height;
	}
	
	/** Sets the patient's measured height */
	public void setHeight(int measuredHeight) {
		this.height = measuredHeight;
	}
	
	/** Returns the patient's measured weight */
	public int getWeight() {
		return weight;
	}
	
	/** Sets the patient's measured weight */
	public void setWeight(int measuredWeight) {
		this.weight = measuredWeight;
	}
	


	/** Returns the patient's calculatedBMI */
	public int getCalculatedBMI() {
		calculateBMI();
		return calculatedBMI;
	}
	
	/** Sets the patient's measured weight */
	public void setCalculatedBMI(int bmi) {
		this.calculatedBMI = bmi;
	}
	
	public String getCreatingUser() {
		return creatingUser;
	}

	public void setCreatingUser(String creatingUser) {
		this.creatingUser = creatingUser;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifyingUser() {
		return modifyingUser;
	}

	public void setModifyingUser(String modifyingUser) {
		this.modifyingUser = modifyingUser;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	/** Calculates patient's BMI if all necessary fields are not null */
	public void calculateBMI()
	{  
		if(height != 0 && weight != 0)
			calculatedBMI = (int) ((int)( weight / (int)(Math.pow(height, 2)) ) * 703.06957964f);

		//excluded for reasons of time.  
//		if(unitSystem == "metric")
//		{
//			bmi = (float)( measuredWeight / Math.pow(measuredHeight, 2));
//		}
	}

	/**
	 * @return the cardID
	 */
	public String getCardID() {
		return cardID;
	}

	/**
	 * @param cardID the cardID to set
	 */
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}


	
}
