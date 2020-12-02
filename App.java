import java.util.InputMismatchException;
import java.util.Scanner;

//This class will be able to run both task and Contact
public class App
{

    public static void main(String []args)
    {
        userAppselect();
    }

//------------------------------------------------------------------------------------------------------------

    private static void userAppselect()
    {
        Scanner in=new Scanner(System.in);
        boolean begin;
        begin = true;
        int choice;

        while(begin)
        {
            try{
                System.out.println("\t\t\tWelcome!!\n");
                System.out.println("\t\t\tSelect Application\n");
                System.out.println("\t\t\t---------------------------");
                System.out.println("\t\t\t1) Task List\n");
                System.out.println("\t\t\t2) Contact List\n");
                System.out.println("\t\t\t3) Quit\n");
                System.out.println("\t\t\t> ");

                choice = in.nextInt();
                switch (choice)
                {
                    case 1 -> TaskApp.main();
                    case 2 -> ContactApp.main();
                    case 3 -> begin = false;
                    default -> throw new IndexOutOfBoundsException();
                }
            }
            catch (IllegalArgumentException | InputMismatchException exception)
            {
                System.out.println("WARNING: ENTER NUMBER 1-3");
            }
        }
    }
}
