import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp
{
    static Scanner in = new Scanner(System.in);

    public static void main()
    {
        userinp();
    }
//------------------------------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------------------------

    private static void saveContact(ContactList contactList)
    {
        try{

            if(contactList.runninC <=0)
                throw new NoSuchFieldException();

            System.out.println("Enter file name to save: ");
            String fileName=in.nextLine();

            contactList.saveContact(fileName);
            System.out.println("Contacts List Saved!");

        } catch (NoSuchFieldException | FileNotFoundException exception)
        {
            System.out.println("WARNING: FILE CANNOT BE SAVED OR FILE DOES NOT EXIST");
            //exception.printStackTrace();
        }
    }
//------------------------------------------------------------------------------------------------------------

    private static void deleteContact(ContactList contactList) {
        try{
            int index;
            if(contactList.runninC <=0)
                throw new NoSuchFieldException();

            System.out.println("\t\t\tCurrent Contacts Available");
            System.out.println("----------------------------------:");
            printContacts(contactList);
            System.out.println("Which contact do you want to remove?");

            index = in.nextInt();

            if(index <0|| (index+1)>contactList.runninC)
                throw new IndexOutOfBoundsException();

            contactList.removeContact(index);
        } catch (NoSuchFieldException exception)
        {
            System.out.println("WARNING: No contacts to remove");
            //exception.printStackTrace();
        }catch (InputMismatchException | IndexOutOfBoundsException exception) {
            System.out.println("WARNING: ENTER THE NUMBER OF CONTACT YOU WANT TO EDIT");
            //exception.printStackTrace();
        }
    }
//------------------------------------------------------------------------------------------------------------

    private static void editContact(ContactList contactList) {
        try{
            if(contactList.runninC <=0){
                throw new NoSuchFieldException();
            }
            System.out.println("\t\t\tCurrent Contacts:");
            System.out.println("----------------------------------:");
            printContacts(contactList);

            System.out.println("Which contact do you want to edit?");
            int index;
            index = in.nextInt();
            in.nextLine();

            if(index<0||(index+1)> contactList.runninC)
            {
                throw new IndexOutOfBoundsException();
            }
            System.out.println("Enter a new first name for contact"+index+":");
            String newFirstName=in.nextLine();

            System.out.println("Enter a new Last name for contact"+index+":");
            String newLastName=in.nextLine();

            System.out.println("Enter a new Phone Number (xxx-xxx-xxxx )for contact"+index+":");
            String newPhoneNumber=in.nextLine();

            System.out.println("Enter a new email for contact"+index+":");
            String newEmail=in.nextLine();

            contactList.editContact(index, newFirstName, newLastName, newPhoneNumber, newEmail);

        }catch (InputMismatchException exception){
            System.out.println("WARNING: ENTER THE NUMBER OF CONTACT YOU WANT TO EDIT");
        }
        catch (NoSuchFieldException exception){
            System.out.println("WARNING: No contacts to edit");
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("WARNING: Cannot access contact index");
        }
        catch (IllegalArgumentException exception){
            System.out.println("WARNING:Contact cannot be created");
        }
    }
//------------------------------------------------------------------------------------------------------------

    private static void addContact(ContactList contactList)
    {
        System.out.println("First Name: ");
        String firstName = in.nextLine();

        System.out.println("Last Name: ");
        String lastName=in.nextLine();

        System.out.println("Phone Number (xxx-xxx-xxxx): ");
        String phoneNumber=in.nextLine();

        System.out.println("Email (x@y.z): ");
        String email=in.nextLine();

        try
        {
            ContactItem contact = new ContactItem(firstName, lastName,phoneNumber,email);

            contact.verify(firstName, lastName, phoneNumber, email);

            contactList.addContact(contact);

        }catch (IllegalArgumentException exception)
        {
            System.out.println("WARNING: MUST PUT SOMETHING IN A MINIMUM OF ONE CATEGORY");
        }
    }
//------------------------------------------------------------------------------------------------------------

    private static void printContacts(ContactList contactList)
    {
        int i;
        i = 0;
        while (i< contactList.runninC)
        {
            ContactItem Contact;
            Contact = contactList.getContact(i);

            System.out.printf("%d) Name: %s %s\nPhone: %s\nEmail: %s\n\n",i, Contact.firstName,
                    Contact.lastName, Contact.phoneNumber, Contact.email);
            i++;
        }
    }
//------------------------------------------------------------------------------------------------------------
    private static void printOperations()
    {
        System.out.println("\n");
        System.out.println("\t\t\tOperations List Menu:\n");
        System.out.println("----------------------------------:\n");
        System.out.println(" (1) View List:\n");
        System.out.println(" (2) Add to Contact list:\n");
        System.out.println(" (3) Edit Contact list:\n");
        System.out.println(" (4) Remove from Contact list:\n");
        System.out.println(" (5) Save current Contact list:\n");
        System.out.println(" (6) Quit to main menu:\n");
        System.out.println("  > ");
    }
//------------------------------------------------------------------------------------------------------------
private static boolean Operations(int choice, ContactList contactList){
    switch(choice)
    {
        case 1:
            System.out.println("\t\t\tCurrent Contacts");
            System.out.println("----------------------------------");
            printContacts(contactList);
        case 2:
            addContact(contactList);
            break;
        case 3:
            editContact(contactList);
            break;
        case 4:
            deleteContact(contactList);
            break;
        case 5:
            saveContact(contactList);
            break;
        case 6:
            return false;
        default:
            throw new IndexOutOfBoundsException();
    }
    return true;
}
//------------------------------------------------------------------------------------------------------------

private static void userinp()
{
    int choice;
    int choicea;
    int choiceb;

    boolean fa = true;
    boolean falo =true;
    boolean falloP = true;

    while (fa)
    {
        System.out.println("Main Contact Menu:\n");
        System.out.println("1) Create New Contact List:\n");
        System.out.println("2) Load Existing Contact List:\n");
        System.out.println("3) Quit:\n");
        System.out.println("> ");

        try{
            choice =in.nextInt();
            in.nextLine();

            switch (choice)
            {
                case 1 -> {

                    ContactList contactList;
                    contactList = new ContactList();

                    System.out.println("Contact List Created!");

                    if (falo) {
                        do {

                            printOperations();
                            try {

                                choicea = in.nextInt();
                                in.nextLine();
                                falo = Operations(choicea, contactList);

                            } catch (InputMismatchException exception) {
                                System.out.println("WARNING: MUST ENTER INTEGER");
                            } catch (IndexOutOfBoundsException exception) {
                                System.out.println("WARNING: Enter a number from 1-6");
                            }
                        } while (falo);
                    }
                }

                case 2 -> {
                    ContactList List;
                    List = new ContactList();

                    System.out.println("Enter name of file");
                    String fileName = in.nextLine();

                    List.loadContact(fileName);
                    System.out.println("Contact list loaded");

                    while (falloP) {
                        printOperations();
                        try {

                            choiceb = in.nextInt();
                            in.nextLine();
                            falloP = Operations(choiceb, List);
                        } catch (InputMismatchException | IndexOutOfBoundsException exception) {
                            System.out.println("WARNING: ENTER CHOICE AS INTEGER");
                        }
                    }
                }
                case 3 -> fa = false;
                default -> throw new IndexOutOfBoundsException();
            }
        }
        catch(IllegalArgumentException | InputMismatchException exception)
        {
            System.out.println("WARNING: ENTER NUMBER 1-3");
        }
        catch(IOException exception){
            System.out.println("WARNING: File not found");
        }
    }
}
}
