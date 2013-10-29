package edu.wayne.cs.raptor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PHARMACY")

public class PharmacyEncounter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="encounterID")
	protected int encounterID;
    @Column(name="cardID")
    protected String cardID;
    @Column(name="firstName")
    protected String firstName;
    @Column(name="lastName")
    protected String lastName;
    @Column(name="medDispensed1")
    protected String medDispensed1;
    @Column(name="medDispensed2")
    protected String medDispensed2;
    @Column(name="medDispensed3")
    protected String medDispensed3;
    @Column(name="medDispensed4")
    protected String medDispensed4;
    @Column(name="medDispensed5")
    protected String medDispensed5;
    @Column(name="equalPrescribed1")
    protected boolean equalPrescribed1;
    @Column(name="equalPrescribed2")
    protected boolean equalPrescribed2;
    @Column(name="equalPrescribed3")
    protected boolean equalPrescribed3;
    @Column(name="equalPrescribed4")
    protected boolean equalPrescribed4;
    @Column(name="equalPrescribed5")
    protected boolean equalPrescribed5;
    @Column(name="creatingUser")
	protected String creatingUser;
    @Column(name="createdDate")
	private Date createdDate;

	public PharmacyEncounter() {
	}
	
	public PharmacyEncounter(int encounterID,String cardID ,String firstName, String lastName, String medDispensed1, 
			String medDispensed2, String medDispensed3, String medDispensed4, String medDispensed5, 
			boolean equalPrescribed1, boolean equalPrescribed2, boolean equalPrescribed3, 
			boolean equalPrescribed4, boolean equalPrescribed5){
		setEncounterID(encounterID);
		setCardID(cardID);
		setFirstName(firstName);
		setLastName(lastName);
		setMedDispensed1(medDispensed1);
		setMedDispensed2(medDispensed2);
		setMedDispensed3(medDispensed3);
		setMedDispensed4(medDispensed4);
		setMedDispensed5(medDispensed5);
		setEqualPrescribed1(equalPrescribed1);
		setEqualPrescribed2(equalPrescribed2);
		setEqualPrescribed3(equalPrescribed3);
		setEqualPrescribed4(equalPrescribed4);
		setEqualPrescribed5(equalPrescribed5);
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatingUser() {
		return creatingUser;
	}

	public void setCreatingUser(String creatingUser) {
		this.creatingUser = creatingUser;
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
	
	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

}