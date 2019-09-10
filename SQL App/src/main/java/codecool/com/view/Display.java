package codecool.com.view;

import codecool.com.model.FileReader;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Display {

    public Display() {
    }

    public static void printMenu(String menuName) {
        List<String> menu = FileReader.readCSV(menuName);
        for (String line:menu) {
            System.out.println(line);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int askForInt(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String out = scanner.next();
        while (!out.matches("[0-9]+")) {
            Display.printMessage("Use only numbers");
            out = scanner.next();
        }
        return Integer.valueOf(out);

    }

    public static String askForString(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String out = scanner.nextLine();
        return out;
    }

    public static void printMessage(String message) {
        System.out.println(message);

    }

    public static void pressForNexxt() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public static void printAllFirstNamesAndLastNamesOfMentors(List<Mentor> getAllFirstNamesAndLastNamesOfMentors){
//
//        int form1 = "First Name".length();
//        int form2 = "Last Name".length();
//
//        for (Mentor mentor : getAllFirstNamesAndLastNamesOfMentors) {
//
//            int form1a = mentor.getFirstName().length();
//            int form2a = mentor.getLastName().length();
//
//            if (form1 <= form1a) form1 = form1a;
//            if (form2 <= form2a) form2 = form2a;
//        }
//
//
//        String formater1 = "%" + form1 + "s";
//        String formater2 = "%" + form2 + "s";
//
//        String output = "";
//
//        String l1 = multiSign(form1, "─");
//        String l2 = multiSign(form2, "─");
//
//        output += "┌" + l1 + "┬" + l2 + "┐\n";
//
//
//        String column1 = String.format(formater1, "First Name");
//        String column2 = String.format(formater2, "Last Name");
//
//        output += "│" + column1 + "│" + column2 + "│\n";
//
//        output += "├" + l1 + "┼" + l2 +"┤\n";
//
//
//        for (Mentor mentor : getAllFirstNamesAndLastNamesOfMentors) {
//
//            String firstname = String.format(formater1, mentor.getFirstName());
//            String prodName = String.format(formater2, mentor.getLastName());
//
//            output += "│" + firstname + "│" + prodName + "│\n";
//
//        }
//        output += "└" + l1 + "┴" + l2 + "┘\n";
//
//        System.out.print(output);
//    }
//
//
//    public static void printAllNicknamesOfMentorsFromMiskolc(List<Mentor> getAllNicknamesOfMentorsFromMiskolc){
//
//        int form1 = "Nicknames of mentors from Miskolc".length();
//
//        for (Mentor mentor : getAllNicknamesOfMentorsFromMiskolc) {
//            int form1a = mentor.getNickName().length();
//            if (form1 <= form1a) form1 = form1a;
//        }
//
//        String formater1 = "%" + form1 + "s";
//        String output = "";
//        String l1 = multiSign(form1, "─");
//        output += "┌" + l1 + "┐\n";
//
//        String column1 = String.format(formater1, "Nicknames of mentors from Miskolc");
//        output += "│" + column1 +"│\n";
//        output += "├" + l1 +"┤\n";
//
//        for (Mentor mentor : getAllNicknamesOfMentorsFromMiskolc) {
//            String nickname = String.format(formater1, mentor.getNickName());
//            output += "│" + nickname + "│\n";
//        }
//        output += "└" + l1 + "┘\n";
//        System.out.print(output);
//    }
//
//    public static void printFullNameOfGirl(String name,List<FullNamePhoneNumber> getCarolFullNameAndPhoneNumber) {
//        String fullName = getCarolFullNameAndPhoneNumber.get(0).getFullname();
//        String phoneNumber = getCarolFullNameAndPhoneNumber.get(0).getPhoneNumber();
//        System.out.println("");
//        System.out.println("----------------------------------------");
//        System.out.println("Full name of "+ name+" and her phone number:");
//        System.out.println("----------------------------------------");
//        System.out.println("Full Name:    "+fullName);
//        System.out.println("Phone Number: "+phoneNumber);
//        System.out.println("----------------------------------------");
//        System.out.println("");
//
//    }
//
//    public static void pfintFullApplicantData(List<Applicant> getAllInfoAboutApplicantUsingApplicationCode) {
//        String firstName = getAllInfoAboutApplicantUsingApplicationCode.get(0).getFirstName();
//        String lastName = getAllInfoAboutApplicantUsingApplicationCode.get(0).getLastName();
//        String phoneNumber = getAllInfoAboutApplicantUsingApplicationCode.get(0).getPhoneNumber();
//        int applicationCode = getAllInfoAboutApplicantUsingApplicationCode.get(0).getApplicationCode();
//        String email = getAllInfoAboutApplicantUsingApplicationCode.get(0).getEmail();
//
//
//        System.out.println("");
//        System.out.println("----------------------------------------");
//        System.out.println("Full applicant Data:");
//        System.out.println("----------------------------------------");
//        System.out.println("First Name:         "+firstName);
//        System.out.println("Last Name:          "+lastName);
//        System.out.println("Phone Number:       "+phoneNumber);
//        System.out.println("Application Code:   "+Integer.toString(applicationCode));
//        System.out.println("E-mail:             "+email);
//        System.out.println("----------------------------------------");
//        System.out.println("");
//
//    }
//
//    public static void printJemimaForeman(List<Applicant> searchJemimaForeman) {
//        String firstName = searchJemimaForeman.get(0).getFirstName();
//        String lastName = searchJemimaForeman.get(0).getLastName();
//        String phoneNumber = searchJemimaForeman.get(0).getPhoneNumber();
//
//
//        System.out.println("");
//        System.out.println("----------------------------------------");
//        System.out.println("Jemima Foreman phone number:");
//        System.out.println("----------------------------------------");
//        System.out.println("First Name:   "+firstName);
//        System.out.println("Last Name:    "+lastName);
//        System.out.println("Phone Number: "+phoneNumber);
//
//        System.out.println("----------------------------------------");
//        System.out.println("");
//
//    }

    private static String multiSign(int multiplication, String sign) {
        String out = "";

        for (int i = 0; i < multiplication; i++) {
            out += sign;
        }
        return out;
    }
}
