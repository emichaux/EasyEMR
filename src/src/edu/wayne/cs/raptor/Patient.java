package edu.wayne.cs.raptor;

import java.util.Date;

import javax.persistence.*;


/**
 * Defines a Patient entity in the system.
 *
 * @author Ramez
 */
@Entity
@Table(name = "PATIENTS")
public class Patient {

    /**
     * A unique Patient identification number
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patientID;
    /**
     * Card ID to create a better use case for a given patient
     */
    private String cardID;
    /**
     * Patient's first name
     */
    private String firstName;
    /**
     * Patient's last name
     */
    private String lastName;
    /**
     * Patient's date of birth
     */
    private String birthDate;
    /**
     * Patient's age
     */
    private String age;
    /**
     * Patient's gender
     */
    private String gender;
    /**
     * Patient's pregers status
     */
    private boolean isPregers;
    /**
     * A set of unique keywords collected from the Patient's relevant medical information/history
     */
    //TODO: figure out how to map collection of strings to SQL column through hibernate.
    private String keywords;
    /**
     * Patient's residence
     */
    private String residence;
    /**
     * The Patient's social/family history. this information shouldn't change much from an encounter
     * to another.
     */
    private String socialHistory;

    /** Identifying image of the patient*/
    //private Bitmap personPhoto;

    /**
     * metadata
     */
    /**
     * User that created this user
     */
    private String creatingUser;
    /**
     * Date this user was first created
     */
    private Date createdDate;
    /**
     * User to last modify or update this user
     */
    private String modifyingUser;
    /**
     * Date last modification of this user took place, creation counts as a modification
     */
    private Date lastModifiedDate;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    private String height;
    private String weight;


    /** TODO:  photos of conditions **/


    /**
     * Default empty constructor
     */
    public Patient() {
    }

    /**
     * Returns the Patient's ID
     */
    @Id
    public int getPatientID() {
        return patientID;
    }

    /**
     * Sets the Patient's ID
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    /**
     * Returns the Patient's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the Patient's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the Patient's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the Patient's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the Patient's gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the Patient's gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Returns the Patient's pregers status
     */
    public boolean isPregers() {
        return isPregers;
    }

    /**
     * Set's the Patient's pregers status
     */
    public void setPregers(boolean pregers) {
        isPregers = pregers;
    }

    /**
     * Returns Patient's date of birth
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the Patient's date of birth
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Return's patient's age
     */
    public String getAge() {
        return age;
    }

    /**
     * Set's Patients age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Returns the Patient's residence
     */
    public String getResidence() {
        return residence;
    }

    /**
     * Sets the Patient's residence
     */
    public void setResidence(String address) {
        this.residence = address;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getSocialHistory() {
        return socialHistory;
    }

    public void setSocialHistory(String socialHistory) {
        this.socialHistory = socialHistory;
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

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

//		public Bitmap getPersonPhoto()
//		{
//			return personPhoto;
//		}
//		public void setPersonPhoto(Bitmap photo)
//		{
//			this.personPhoto = photo;
//		}
}
