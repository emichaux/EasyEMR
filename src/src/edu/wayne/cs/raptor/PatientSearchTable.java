package edu.wayne.cs.raptor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * User: Evan
 * Date: 10/6/13
 */
@ManagedBean
@ViewScoped
public class PatientSearchTable {
    private String firstName;
    private String ageResult;
    private String lastNameResult;
    private String genderResult;
    private String heightResult;
    private String ageIntResult;
    private String locationResult;

    public PatientSearchTable(String firstName,  String lastNameResult, String ageResult, String locationResult,  String genderResult, String heightResult, String ageIntResult) {
        this.firstName = firstName;
        this.ageResult = ageResult;
        this.lastNameResult = lastNameResult;
        this.genderResult = genderResult;
        this.heightResult = heightResult;
        this.ageIntResult = ageIntResult;
        this.locationResult = locationResult;
    }

    public String getLocationResult() {
        return locationResult;
    }

    public void setLocationResult(String locationResult) {
        this.locationResult = locationResult;
    }

    public String getGenderResult() {
        return genderResult;
    }

    public void setGenderResult(String genderResult) {
        this.genderResult = genderResult;
    }

    public String getHeightResult() {
        return heightResult;
    }

    public void setHeightResult(String heightResult) {
        this.heightResult = heightResult;
    }

    public String getAgeIntResult() {
        return ageIntResult;
    }

    public void setAgeIntResult(String ageIntResult) {
        this.ageIntResult = ageIntResult;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getageResult() {
        return ageResult;
    }

    public void setageResult(String ageResult) {
        this.ageResult = ageResult;
    }

    public String getlastNameResult() {
        return lastNameResult;
    }

    public void setlastNameResult(String lastNameResult) {
        this.lastNameResult = lastNameResult;
    }

}
