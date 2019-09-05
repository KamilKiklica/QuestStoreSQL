package codecool.com.model.interfaces;

import codecool.com.model.Applicant;
import codecool.com.model.FullNamePhoneNumber;

import java.util.List;

public interface ApplicantsDAOInterface {

    public List<FullNamePhoneNumber> getCarolFullNameAndPhoneNumber();

    public List<FullNamePhoneNumber> getOtherGirlFullNameAndPhoneNumberUsingEmail();

    public void addNewApplicant(Applicant applicant);

    public List<Applicant> getAllInfoAboutApplicantUsingApplicationCode();

    public void updatePhoneNumber(String telephoneNumber);

    public List<Applicant> checkPhoneNumber();

    public void deleteApplicantsWithMausiseuEmailDomain();
}
