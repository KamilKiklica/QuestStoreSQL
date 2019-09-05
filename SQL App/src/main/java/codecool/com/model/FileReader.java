package codecool.com.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String> readCSV(String menuName) {

        List<String> lines = new ArrayList<>();

        try{
            File file = new File("lib/"+ menuName);


            Scanner input = new Scanner(file);

            while (input.hasNextLine()){

                lines.add(input.nextLine());
            }
            input.close();
        }   catch (Exception ex){
            ex.printStackTrace();
        }

        return lines;
    }
}
