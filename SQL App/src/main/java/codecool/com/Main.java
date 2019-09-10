package codecool.com;

import codecool.com.controller.MentorController;
import codecool.com.controller.RootController;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
//        MentorController dataBaseController = new MentorController();
//        dataBaseController.run();

        RootController rootController = new RootController();
        rootController.run();
    }
}
