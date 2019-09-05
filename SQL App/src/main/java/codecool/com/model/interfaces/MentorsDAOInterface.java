package codecool.com.model.interfaces;

import codecool.com.model.Mentor;

import java.util.List;

public interface MentorsDAOInterface {

    public List<Mentor> getAllFirstNamesAndLastNamesOfMentors();
    public List<Mentor> getAllNicknamesOfMentorsFromMiskolc();

    }