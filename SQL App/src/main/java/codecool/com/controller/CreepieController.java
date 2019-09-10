package codecool.com.controller;

import codecool.com.model.sql.queries.CreepieQuery;
import codecool.com.model.User;
import codecool.com.view.Display;

import java.util.List;

public class CreepieController {
    User user;


    public CreepieController (User user) {
    this.user = user;
}

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            Display.clearScreen();
            Display.printMenu("creepieMenu");

            int option = Display.askForInt("Choose an option");

            switch (option) {
                case 1: {
                    createMentor();
                    Display.pressForNexxt();
                    break;
                }
                case 2: {
                    updateMentor();
                    Display.pressForNexxt();
                    break;
                }
                case 3: {
                    showMentorsProfiles(new CreepieQuery().readAllMentors());
                    Display.pressForNexxt();
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

    private void createMentor(){
        User user = new User();
        user.setFirstName(Display.askForString("First name: "));
        user.setLastName(Display.askForString("Last name: "));
        user.setEmail(Display.askForString("Email: "));
        user.setNickName(Display.askForString("Nick name: "));
        user.setPassword(Display.askForString("Password: "));
//        String photo = Display.askForString("Product name: ");
        user.setAccessRights(Display.askForInt("Access rights: "));
        new CreepieQuery().createMentor(user);
    }


    private void updateMentor(){
        showMentorsProfiles(new CreepieQuery().readAllMentors());
        int indexUser = Display.askForInt("Choose ID of Mentor to Update: ")-1;
        User user = new CreepieQuery().readAllMentors().get(indexUser);
        user.setFirstName(Display.askForString("First name: "));
        user.setLastName(Display.askForString("Last name: "));
        user.setEmail(Display.askForString("Email: "));
        user.setNickName(Display.askForString("Nick name: "));
        user.setPassword(Display.askForString("Password: "));
//        String photo = Display.askForString("Product name: ");
        user.setAccessRights(Display.askForInt("Access rights: "));
        new CreepieQuery().updateMentor(user);
    }

    private void showMentorsProfiles(List<User> mentors){
            for (int i = 0; i < mentors.size(); i++) {
                User user = mentors.get(i);
                 System.out.println(i+1+". "+user.getFirstName()+ " " +user.getLastName()+ " " +user.getNickName()+ " " +user.getEmail()+ " " +user.getPhotoUrl()+ " " +user.getClass());
            }
        System.out.println();
        }
    }
