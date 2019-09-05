package codecool.com.model.dao;

import codecool.com.model.interfaces.CSVDAOInterface;
import codecool.com.model.sql.queries.MentorQuery;
import codecool.com.model.sql.queries.ApplicantQuery;
import codecool.com.model.Applicant;
import codecool.com.model.FileReader;
import codecool.com.model.Mentor;

import java.util.ArrayList;
import java.util.List;

public class CSVDAO implements CSVDAOInterface {
    MentorQuery mentorQuery = new MentorQuery();
    ApplicantQuery applicantQuery = new ApplicantQuery();

    private List<Mentor> makeMentorsListFromCSV(String filename) {
        List<String> mentorsAsStringArrayList = FileReader.readCSV(filename);
        List<Mentor> mentors = new ArrayList<>();
        for (String element : mentorsAsStringArrayList) {
            String[] parts = element.split(",");
            for (int i = 0; i< parts.length-1; i++) {
                parts[i] = parts[i].substring(1,parts[i].length()-1);
            }
            String firstname = parts[0];
            String lastname = parts[1];
            String nickName = parts[2];
            String phoneNumber = parts[3];
            String email = parts[4];
            String city = parts[5];
            int favouriteNumber;
            if (!parts[6].equals("NULL")) {favouriteNumber = Integer.parseInt(parts[6]);} else {favouriteNumber = 0;}
            Mentor newMentor = new Mentor();
            newMentor.setFirstName(firstname);
            newMentor.setLastName(lastname);
            newMentor.setNickName(nickName);
            newMentor.setPhoneNumber(phoneNumber);
            newMentor.setEmail(email);
            newMentor.setCity(city);
            newMentor.setFavouriteNumber(favouriteNumber);
            mentors.add(newMentor);
        }
        return mentors;

    }

    private List<Applicant> makeApplicantsFromCSV(String filename) {
        List<String> mentorsAsStringArrayList = FileReader.readCSV(filename);
        List<Applicant> applicants = new ArrayList<>();
        for (String element : mentorsAsStringArrayList) {
            String[] parts = element.split(",");
            for (int i = 0; i< parts.length-1; i++) {
                parts[i] = parts[i].substring(1,parts[i].length()-1);
            }
            String firstname = parts[0];
            String lastname = parts[1];
            String phoneNumber = parts[2];
            String email = parts[3];
            int applicationCode = Integer.parseInt(parts[4]);
            Applicant newApplicant = new Applicant();
            newApplicant.setFirstName(firstname);
            newApplicant.setLastName(lastname);
            newApplicant.setEmail(email);
            newApplicant.setPhoneNumber(phoneNumber);
            newApplicant.setApplicationCode(applicationCode);
            applicants.add(newApplicant);
        }
        return applicants;
    }


    @Override
    public void addMentorsFromCSVToDataBase(String filename) {
        List<Mentor> mentors = makeMentorsListFromCSV(filename);
        for (Mentor mentor : mentors) {
            mentorQuery.createMentor(mentor);
        }
        System.out.println(mentors.size() + " Mentors added successfully");
    }

    @Override
    public void addApplicantsFromCSVToDataBase(String filename) {
        List<Applicant> applicants = makeApplicantsFromCSV(filename);
        for (Applicant applicant: applicants) {
            applicantQuery.createApplicant(applicant);
        }
        System.out.println(applicants.size() + " Applicants added successfully");

    }
}


