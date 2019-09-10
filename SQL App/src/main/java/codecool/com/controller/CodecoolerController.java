package codecool.com.controller;

import codecool.com.model.User;
import codecool.com.view.Display;

public class CodecoolerController {
    User user;

public CodecoolerController(User user){
    this.user = user;
}

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            Display.clearScreen();
            Display.printMenu("codecoolerMenu");

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
