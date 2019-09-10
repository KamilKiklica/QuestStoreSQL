package codecool.com.controller;

import codecool.com.model.dao.MentorDAO;
//import codecool.com.model.dao.CSVDAO;
import codecool.com.model.dao.CodecoolerDAO;
import codecool.com.model.User;
import codecool.com.view.Display;

public class MentorController {
    MentorDAO applicantsDAO = new MentorDAO();
    CodecoolerDAO mentorsDAO = new CodecoolerDAO();
//    CSVDAO csvdao = new CSVDAO();
    User user;

    public MentorController(User user) {
        this.user = user;
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            Display.clearScreen();
            Display.printMenu("mentorMenu");

            int option = Display.askForInt("Choose an option");

            switch (option) {
                case 1: {
//                    logInUser();
                    break;
                }

                case 0: {
                    isRunning = false;
                    break;
                }
                default: {
                }

            }
        }
    }
}
