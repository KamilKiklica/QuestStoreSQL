package codecool.com.model.dao;

import codecool.com.model.Applicant;
import codecool.com.model.FullNamePhoneNumber;
import codecool.com.model.interfaces.ApplicantsDAOInterface;
import codecool.com.model.sql.queries.ApplicantQuery;

import java.util.List;

public class ApplicantsDAO implements ApplicantsDAOInterface {

    private ApplicantQuery applicantQuery = new ApplicantQuery();

    public ApplicantsDAO(){}

    @Override
    public List<FullNamePhoneNumber> getCarolFullNameAndPhoneNumber() {
        return applicantQuery.searchForCarol();
    }

    @Override
    public List<FullNamePhoneNumber> getOtherGirlFullNameAndPhoneNumberUsingEmail() {
    return applicantQuery.searchByEmailDomain();
    }

    @Override
    public void addNewApplicant(Applicant applicant) {
        applicantQuery.createApplicant(applicant);
    }

    @Override
    public List<Applicant> getAllInfoAboutApplicantUsingApplicationCode() {
        return applicantQuery.searchByApplicationCode();
    }

    @Override
    public void updatePhoneNumber(String telephoneNumber) {
        applicantQuery.updateJemimaForemanPhoneNumber(telephoneNumber);
    }

    @Override
    public List<Applicant> checkPhoneNumber() {
        return applicantQuery.searchJemimaForeman();
    }

    @Override
    public void deleteApplicantsWithMausiseuEmailDomain() {
        applicantQuery.deleteApplicantsWithMausiseuEmailDomain();
    }

    public void deleteAllApplicants() {
        applicantQuery.deleteAllApplicants();
    }


}
