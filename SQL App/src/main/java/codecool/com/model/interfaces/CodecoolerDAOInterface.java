package codecool.com.model.interfaces;

import codecool.com.model.User;

public interface CodecoolerDAOInterface {

    public User createMentor();
    public User editMentor(User mentor);
    public void showMentorProfile(User mentor);
    public void createClass();
    public void createExperienceLevel();
}
