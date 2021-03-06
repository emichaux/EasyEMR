package edu.wayne.cs.raptor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/** Defines an Encounter. An encounter should track all the interactions between the patient
 *  and any clinic personnel for a given chief-complaint/visit.
 * 
 * @authors Ramez Habib, Tom Hickman, Jackson Turner , Ryan Doubleday
 *
 */
@Entity
@Table(name = "ENCOUNTERS")
public class Encounter implements Serializable {
	
	/** A unique Encounter identification number */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="encounterID")
	private int encounterID;

	/** The id of the patient for whom the encounter is in progress */
    @Column (name = "patientID")
    private int patientID;

	/** Card ID to create a better use case for a given patient */
    @Column (name = "cardID")
    private String cardID;

	//figure out how to deal with images using jsp
	//private Bitmap personPhoto
	
	/** The stated chief complaint for an encounter */
    @Column (name = "chiefComplaint")
    private String chiefComplaint;
	
	/** Attributes related to the HPI Section, created by Tom Hickman **/
    @Column (name = "onsetNumber")
    private int onsetNumber;
    @Column (name = "onsetUnit")
	private String onsetUnit;
    @Column (name = "severity")
	private int severity;
    @Column (name = "radiation")
	private String radiation;
    @Column (name = "quality")
	private String quality;
    @Column (name = "provokes")
	private String provokes;
    @Column (name = "timeOfDay")
	private String timeOfDay;
    @Column (name = "other")
	private String other;	
	/** End HPI **/
	
	/** Medications Prescribed **/
    @Column (name = "medicationPrescribed1")
	private String medicationPrescribed1;
    @Column (name = "medicationPrescribed2")
    private String medicationPrescribed2;
    @Column (name = "medicationPrescribed3")
    private String medicationPrescribed3;
    @Column (name = "medicationPrescribed4")
    private String medicationPrescribed4;
    @Column (name = "medicationPrescribed5")
    private String medicationPrescribed5;
	
	
	/** A chronic/other illnesses discovered in the encounter 
	 * TODO:  The names of previously discovered chronic illnesses should be automatically displayed,
	 *  Method to access/edit if desired. if it's resolved should not be displayed during future encounters 
	 *  (but not removed from previously recorded encounters)
	 */
    @Column (name = "condition1")
	private String condition1;
    @Column (name = "condition2")
    private String condition2;
    @Column (name = "condition3")
    private String condition3;
    @Column (name = "condition4")
    private String condition4;
    @Column (name = "condition5")
    private String condition5;
	
	/** Results of physical examination */
    @Column (name = "overallImpression")
    private String overallImpression;
	
	/** Keywords for this encounter */
    @Column (name = "keywords")
    private String keywords;
	
	/** Any medical procedures the Patient has undergone in the past or the current encounter */
    @Column (name = "medicalProcedures")
    private String medicalProcedures;
    @Column (name = "assessment")
	private String assessment;

	/** 
	 * metadata
	 */
	/** User that created this user */
    @Column (name = "creatingUser")
    private String creatingUser;
	
	/** Date this user was first created */
    @Column (name = "createdDate")
    private Date createdDate;
	
	/** User to last modify or update this user */
    @Column (name = "modifyingUser")
    private String modifyingUser;
	
	/** Date last modification of this user took place, creation counts as a modification */
    @Column (name = "lastModifiedDate")
    private Date lastModifiedDate;

	
	
	/** Default empty constructor */
	public Encounter(){		
	}

	/** Returns the encounter ID number */

	public int getEncounterID() {
		return encounterID;
	}

	/** Sets the encounter ID number */
	public void setEncounterID(int encounterID) {
		this.encounterID = encounterID;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	/** Returns the chief complaint in the encounter*/
	public String getChiefComplaint() {
		return chiefComplaint;
	}

	/** Sets the chief complaint */
	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public int getOnsetNumber() {
		return onsetNumber;
	}

	public void setOnsetNumber(int onsetNumber) {
		this.onsetNumber = onsetNumber;
	}

	public String getOnsetUnit() {
		return onsetUnit;
	}

	public void setOnsetUnit(String onsetUnit) {
		this.onsetUnit = onsetUnit;
	}

	public String getCondition1() {
		return condition1;
	}

	public void setCondition1(String otherIllness1) {
		this.condition1 = otherIllness1;
	}

	public String getCondition2() {
		return condition2;
	}

	public void setCondition2(String otherIllness2) {
		this.condition2 = otherIllness2;
	}

	public String getCondition3() {
		return condition3;
	}

	public void setCondition3(String otherIllness3) {
		this.condition3 = otherIllness3;
	}
	
	public String getCondition4() {
		return condition4;
	}

	public void setCondition4(String condition4) {
		this.condition4 = condition4;
	}

	public String getCondition5() {
		return condition5;
	}

	public void setCondition5(String condition5) {
		this.condition5 = condition5;
	}
	

	/** Returns the keywords of the encounter */
	public String getKeywords() {
		return keywords;
	}

	/** Sets the keywords of the encounter */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getMedicalProcedures() {
		return medicalProcedures;
	}

	public void setMedicalProcedures(String medicalProcedures) {
		this.medicalProcedures = medicalProcedures;
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

	
	/** Methods below are relevant to fields in the HPI section, created by Tom Hickman **/
	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public String getRadiation() {
		return radiation;
	}

	public void setRadiation(String radiation) {
		this.radiation = radiation;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getProvokes() {
		return provokes;
	}

	public void setProvokes(String provokes) {
		this.provokes = provokes;
	}

	public String getTimeOfDay() {
		return timeOfDay;
	}

	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getMedicationPrescribed1() {
		return medicationPrescribed1;
	}

	public void setMedicationPrescribed1(String medicationPrescribed1) {
		this.medicationPrescribed1 = medicationPrescribed1;
	}

	public String getMedicationPrescribed2() {
		return medicationPrescribed2;
	}

	public void setMedicationPrescribed2(String medicationPrescribed2) {
		this.medicationPrescribed2 = medicationPrescribed2;
	}

	public String getMedicationPrescribed3() {
		return medicationPrescribed3;
	}

	public void setMedicationPrescribed3(String medicationPrescribed3) {
		this.medicationPrescribed3 = medicationPrescribed3;
	}

	public String getMedicationPrescribed4() {
		return medicationPrescribed4;
	}

	public void setMedicationPrescribed4(String medicationPrescribed4) {
		this.medicationPrescribed4 = medicationPrescribed4;
	}

	public String getMedicationPrescribed5() {
		return medicationPrescribed5;
	}

	public void setMedicationPrescribed5(String medicationPrescribed5) {
		this.medicationPrescribed5 = medicationPrescribed5;
	}

	public String getOverallImpression() {
		return overallImpression;
	}

	public void setOverallImpression(String overallImpression) {
		this.overallImpression = overallImpression;
	}

	public String getAssessment() {
		return assessment;
	}

	public void setAssessment(String assessment) {
		this.assessment = assessment;
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