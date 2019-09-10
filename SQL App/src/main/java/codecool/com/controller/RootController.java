package codecool.com.controller;

import codecool.com.model.sql.queries.UserQuery;
import codecool.com.model.User;
import codecool.com.view.Display;

import java.util.Scanner;

public class RootController {

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            Display.clearScreen();
            Display.printMenu("logMenu");

            int option = Display.askForInt("Choose an option");

            switch (option) {
                case 1: {
                    logInUser();
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

    public void logInUser() {
        Scanner scanner = new Scanner(System.in);
        Display.printMessage("User name: ");
        String name = scanner.nextLine();
        Display.printMessage("User password: ");
        String password = scanner.nextLine();
        if (new UserQuery().readUser(name, password).getNickName() == null) {
            Display.printMessage("Wrong username or password.");
        } else {
            User user = new UserQuery().readUser(name, password);
            logInUserByAccessRights(user);
        }

    }

    public void logInUserByAccessRights(User user) {
        if (user.getAccessRights() == 1) {
            CreepieController creepieController = new CreepieController(user);
            creepieController.run();
        } else if (user.getAccessRights() == 2) {
            MentorController customerController = new MentorController(user);
            customerController.run();
        } else if (user.getAccessRights() == 3) {
            CodecoolerController codecoolerController = new CodecoolerController(user);
            codecoolerController.run();
        }
    }

}
