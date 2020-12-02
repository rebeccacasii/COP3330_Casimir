import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {

    ContactList contactL =new ContactList();
    ContactItem contactI = new ContactItem("Name", "Last", "555-555-5555",
            "testemail@gmail.com");


    @Test
    public void newListIsEmpty()
    {
        Assertions.assertEquals(0, contactL.runninC);
    }

    @Test
    public void addingItemsIncreasesSize()
    {
        contactL.addContact(contactI);
        contactL.addContact(contactI);
        contactL.addContact(contactI);
        assertEquals(3, contactL.runninC);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues()
    {
        assertThrows(
                IndexOutOfBoundsException.class,
                () ->{
                    contactL.addContact(contactI);
                    contactL.editContact(1,"","","","");
                }
        );
    }

    @Test
    public void editingSucceedWithBlankFirstName()
    {
        Assertions.assertDoesNotThrow( () ->{
                    contactL.addContact(contactI);
                    contactL.editContact(0,"","Test","444-444-4444",
                            "test2@gmail.com");
                    contactI.verify(contactI.firstName, contactI.lastName, contactI.phoneNumber, contactI.email);
                }
        );
    }

    @Test
    public void editingSucceedWithBlankLastName()
    {
        Assertions.assertDoesNotThrow( () ->
                {
                    contactL.addContact(contactI);
                    contactL.editContact(0,"Test","","444-444-4444",
                            "test2@gmail.com");
                    contactI.verify(contactI.firstName, contactI.lastName, contactI.phoneNumber, contactI.email);
                }
        );
    }

    @Test
    public void editingSucceedWithBlankPhone()
    {
        Assertions.assertDoesNotThrow( () ->
                {
                    contactL.addContact(contactI);
                    contactL.editContact(0,"Test","test","",
                            "test2@gmail.com");
                    contactI.verify(contactI.firstName, contactI.lastName, contactI.phoneNumber, contactI.email);
                }
        );
    }

    @Test
    public void editingSucceedWithBlankEmail()
    {
        Assertions.assertDoesNotThrow( () ->
                {
                    contactL.addContact(contactI);
                    contactL.editContact(0,"Test","test","444-444-4444",
                            "");
                    contactI.verify(contactI.firstName, contactI.lastName, contactI.phoneNumber, contactI.email);
                }
        );

    }

    @Test
    public void editingSucceedsWithNoBlankValues()
    {
        assertDoesNotThrow( () ->
                {
                    contactL.addContact(contactI);
                    contactL.editContact(0,"Test","test","444-444-4444",
                            "test2@gmail.com");
                    contactI.verify(contactI.firstName, contactI.lastName, contactI.phoneNumber, contactI.email);
                }
        );
    }

    @Test
    public void removingItemsDecreasesSize()
    {
        contactL.addContact(contactI);
        contactL.removeContact(0);
        assertEquals(0, contactL.runninC);
    }

    @Test
    public void savedContactListCanBeLoaded() throws IOException
    {
            contactL.loadContact("testing");
    }

    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        assertThrows(
                IndexOutOfBoundsException.class,
                ()->{
                    contactL.addContact(contactI);
                    contactL.removeContact(1);
                }
        );
    }


}
