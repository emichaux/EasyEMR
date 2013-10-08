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

    public PatientSearchTable(String firstName, String lastNameResult, String ageResult) {
        this.firstName = firstName;
        this.lastNameResult = lastNameResult;
        this.ageResult = ageResult;
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
