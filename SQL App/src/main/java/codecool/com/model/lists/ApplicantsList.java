package codecool.com.model.lists;

import codecool.com.model.Applicant;
import java.util.List;

public class ApplicantsList{
    List<Applicant> applicants;

    public ApplicantsList(List<Applicant> applicants) {
        this.applicants = applicants;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }
}
