package codecool.com.model.lists;

import codecool.com.model.Mentor;
import java.util.List;

public class MentorsList {


    List<Mentor> mentors;

    public MentorsList(List<Mentor> mentors) {
        this.mentors = mentors;
    }


    public List<Mentor> getMentors() {
        return mentors;
    }
}
