package codecool.com.model.interfaces;

public interface CSVDAOInterface {

    public void addMentorsFromCSVToDataBase(String filename);
    public void addApplicantsFromCSVToDataBase(String filename);

}
