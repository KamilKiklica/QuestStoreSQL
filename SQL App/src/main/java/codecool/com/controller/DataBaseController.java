package codecool.com.controller;

import codecool.com.model.Applicant;
import codecool.com.model.dao.ApplicantsDAO;
import codecool.com.model.dao.CSVDAO;
import codecool.com.model.dao.MentorsDAO;
import codecool.com.view.Display;

public class DataBaseController {
    ApplicantsDAO applicantsDAO = new ApplicantsDAO();
    MentorsDAO mentorsDAO = new MentorsDAO();
    CSVDAO csvdao = new CSVDAO();

    public DataBaseController() {
    }

    public void run() {
        boolean isRunning = true;
        //Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            Display.clearScreen();
            Display.printMenu("menu.txt");
            int option = Display.askForInt("Choose an option");

            switch (option) {

                case 1: {
                    Display.clearScreen();
                    Display.printAllFirstNamesAndLastNamesOfMentors(mentorsDAO.getAllFirstNamesAndLastNamesOfMentors());
                    Display.pressForNexxt();
                    break;
                }
                case 2: {
                    Display.clearScreen();
                    Display.printAllNicknamesOfMentorsFromMiskolc(mentorsDAO.getAllNicknamesOfMentorsFromMiskolc());
                    Display.pressForNexxt();
                    break;
                }
                case 3: {
                    Display.clearScreen();
                    Display.printFullNameOfGirl("Carol",applicantsDAO.getCarolFullNameAndPhoneNumber());
                    Display.pressForNexxt();
                    break;
                }
                case 4: {
                    Display.clearScreen();
                    Display.printFullNameOfGirl("girl by email", applicantsDAO.getOtherGirlFullNameAndPhoneNumberUsingEmail());
                    Display.pressForNexxt();
                    break;
                }

                case 5: {
                    Display.clearScreen();
                    Applicant markus = new Applicant();
                    markus.setFirstName("Markus");
                    markus.setLastName("Schaffarzyk");
                    markus.setPhoneNumber("003620/725-2666");
                    markus.setEmail("djnovus@groovecoverage.com");
                    markus.setApplicationCode(54823);
                    applicantsDAO.addNewApplicant(markus);
                    Display.printMessage("Applicant succesfully added to DataBase");
                    Display.pressForNexxt();
                    break;
                }
                case 6: {
                    Display.clearScreen();
                    Display.pfintFullApplicantData(applicantsDAO.getAllInfoAboutApplicantUsingApplicationCode());
                    Display.pressForNexxt();
                    break;
                }
                case 7: {
                    Display.clearScreen();
                    applicantsDAO.updatePhoneNumber("003670/223-7459");
                    Display.pressForNexxt();
                    break;
                }
                case 8: {
                    Display.clearScreen();
                    Display.printJemimaForeman(applicantsDAO.checkPhoneNumber());
                    Display.pressForNexxt();
                    break;
                }
                case 9: {
                    Display.clearScreen();
                    applicantsDAO.deleteApplicantsWithMausiseuEmailDomain();
                    Display.printMessage("Users with domain mauriseu.net has been succesfully deleted.");
                    Display.pressForNexxt();
                    break;
                }

                case 10: {
                    applicantsDAO.deleteAllApplicants();
                    mentorsDAO.deleteAllMentors();
                    Display.printMessage("Data succesfully deleted.");
                    Display.pressForNexxt();
                    break;

                }
                case 11: {
                    csvdao.addApplicantsFromCSVToDataBase("applicants.csv");
                    csvdao.addMentorsFromCSVToDataBase("mentors.csv");
                    Display.pressForNexxt();
                    break;

                }

//                case 12: {
//
//
//                }

                case 0: {
                    isRunning = false;
                    break;
                }
                default: {
//                    Display.clearScreen();
                }
            }
        }
    }
}
