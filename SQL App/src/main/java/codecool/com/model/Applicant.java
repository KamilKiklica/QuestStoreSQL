package codecool.com.model;

public class Applicant extends AbstractUser {

    private int applicationCode;

    public Applicant() {
    }

    public int getApplicationCode() {
        return applicationCode;
    }
    public void setApplicationCode(int applicationCode) {
        this.applicationCode = applicationCode;
    }

}
