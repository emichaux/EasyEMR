package edu.wayne.cs.raptor;

/**
 * Created with IntelliJ IDEA.
 * User: Evan
 * Date: 10/6/13
 */
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
