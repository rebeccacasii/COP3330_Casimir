import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Formatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList
{
    int runninC =0;

    ArrayList<ContactItem>contacts;
    {
        contacts = new ArrayList<>();
    }
//------------------------------------------------------------------------------------------------------------

    ContactItem getContact(int index)
    {
        return contacts.get(index);
    }
//------------------------------------------------------------------------------------------------------------

    void addContact(ContactItem contact)
    {
        contacts.add(contact);
        runninC++;
    }
//------------------------------------------------------------------------------------------------------------

    void editContact(int index, String firstName, String lastName, String phoneNumber, String Email) {
        ContactItem contacted = getContact(index);

        contacted.verify(firstName, lastName, phoneNumber, Email);
        contacted.setFirstName(firstName);
        contacted.setLastName(lastName);
        contacted.setPhoneNumber(phoneNumber);
        contacted.setEmail(Email);
    }
//------------------------------------------------------------------------------------------------------------

    void removeContact(int index)
    {
        contacts.remove(index);
        runninC--;
    }
//------------------------------------------------------------------------------------------------------------

    void saveContact(String fileName)throws FileNotFoundException
    {
        try (Formatter ouput = new Formatter(fileName)) {
            for (int i = 0; i < runninC; i++) {
                ContactItem contactItem = getContact(i);
                ouput.format(contactItem.toString());
            }
            ouput.close();
        }
    }
//------------------------------------------------------------------------------------------------------------

    void loadContact(String fileName)throws IOException
    {
        Scanner file;
        file = new Scanner(Paths.get(fileName));
        try {
            while (file.hasNext())
            {
                ContactItem contacti;
                String first;
                first = file.nextLine();

                String last;
                last = file.nextLine();

                String phone;
                phone = file.nextLine();

                String Email;
                Email = file.nextLine();

                //ContactItem loadedContact;
                contacti = new ContactItem(first, last,
                        phone, Email);

                contacti.verify(first, last,
                        phone, Email);
                addContact(contacti);

            }
        } finally {
            file.close();
        }
    }
//------------------------------------------------------------------------------------------------------------

}
