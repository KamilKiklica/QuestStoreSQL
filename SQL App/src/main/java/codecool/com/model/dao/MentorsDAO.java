package codecool.com.model.dao;

import codecool.com.model.interfaces.MentorsDAOInterface;
import codecool.com.model.sql.queries.MentorQuery;
import codecool.com.model.Mentor;

import java.util.List;

public class MentorsDAO implements MentorsDAOInterface {
    private MentorQuery mentorQuery = new MentorQuery();

    public MentorsDAO() {
    }
    @Override
    public List<Mentor> getAllFirstNamesAndLastNamesOfMentors() {
        return mentorQuery.readAllFirstNameAndLastNameOfMentors();
    }
    @Override
    public List<Mentor> getAllNicknamesOfMentorsFromMiskolc() {
        return mentorQuery.readNicknamesOfMentorsFromMiskolc();
    }

    public void deleteAllMentors() {
        mentorQuery.deleteAllMentors();
    }

}
