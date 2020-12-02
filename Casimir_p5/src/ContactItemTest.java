import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

    ContactItem contact = new ContactItem("Test","Test", "555-555-5555",
            "testing@gmail.com");


    @Test
    public void testToString()
    {
        assertEquals("Test\nTest\n555-555-5555\ntesting@gmail.com", contact.toString());
    }


    @Test
    public void creationFailsWithAllBlackValues()
    {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                ()->
                {
                    ContactItem contactI = new ContactItem("","","","");
                    contactI.verify("","","","");
                }
        );
    }

    @Test
    public void creationSucceedsWithBlankEmail()
    {
        Assertions.assertDoesNotThrow(
                ()->
                {
            ContactItem contactI = new ContactItem("Test","Test", "555-555-5555",
                    "");
            contactI.verify("Test","Test", "555-555-5555",
                    "");
        }
        );
    }

    @Test
    public void creationSucceedsWithBlankFirstName()
    {
        Assertions.assertDoesNotThrow(()->{
                    ContactItem contactI = new ContactItem("","Test", "555-555-5555",
                            "testing@gmail.com");
                    contactI.verify("","Test", "555-555-5555",
                            "testing@gmail.com");
                }
        );
    }

    @Test
    public void creationSucceedsWithBlankLastName()
    {
        assertDoesNotThrow(()->{
                    ContactItem contact = new ContactItem("Test","", "555-555-5555",
                            "testing@gmail.com");
                    contact.verify("Test","", "555-555-5555",
                            "testing@gmail.com");
                }
        );
    }

    @Test
    public void creationSucceedsWithBlankPhone()
    {
        assertDoesNotThrow(()->{
                    ContactItem contact = new ContactItem("Test","Test", "",
                            "testing@gmail.com");
                    contact.verify("Test","Test", "",
                            "testing@gmail.com");
                }
        );
    }

    @Test
    public void creationSucceedsWithNoBlankValues()
    {
        assertDoesNotThrow(
                ()-> contact.verify("Test","Test", "555-555-5555",
                "testing@gmail.com")
        );
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        assertThrows(
                IllegalArgumentException.class,()->{
                    ContactItem contactI = new ContactItem("Test","Test", "555-555-5555",
                            "testing@gmail.com");
                    contactI.setFirstName("");
                    contactI.setLastName("");
                    contactI.setPhoneNumber("");
                    contactI.setEmail("");
                    contactI.verify("","", "",
                            "");
                }
        );
    }

    @Test
    public void editingSucceedsWithBlankEmail()
    {
        Assertions.assertDoesNotThrow(()->
        {
            ContactItem contacI;
            contacI = new ContactItem("Test","Test", "555-555-5555",
                    "testing@gmail.com");

            contacI.setFirstName("Testing");
            contacI.setLastName("Test");
            contacI.setPhoneNumber("555-555-5555");
            contacI.setEmail("");

            contacI.verify(contacI.firstName, contacI.lastName, contacI.phoneNumber,
                    contacI.email);
        });
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        assertDoesNotThrow(
                ()->{
            contact.setFirstName("");
            contact.setLastName("Test");
            contact.setPhoneNumber("555-555-5555");
            contact.setEmail("testing@gmail.com");
            contact.verify(contact.firstName, contact.lastName, contact.phoneNumber,
                    contact.email);
        });
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        assertDoesNotThrow(
                ()->
        {
            contact.setFirstName("Test");
            contact.setLastName("");
            contact.setPhoneNumber("555-555-5555");
            contact.setEmail("testing@gmail.com");
            contact.verify(contact.firstName, contact.lastName, contact.phoneNumber,
                    contact.email);
        });
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        assertDoesNotThrow(
                ()->
        {
            contact.setFirstName("Test");
            contact.setLastName("Test");
            contact.setPhoneNumber("");
            contact.setEmail("testing@gmail.com");
            contact.verify(contact.firstName, contact.lastName, contact.phoneNumber,
                    contact.email);
        });
    }

    @Test
    public void editingSucceedsWithNoBlankValue(){
        assertDoesNotThrow(
                ()->{
            contact.setFirstName("Test");
            contact.setLastName("Test");
            contact.setPhoneNumber("555-555-5555");
            contact.setEmail("testing@gmail.com");
            contact.verify(contact.firstName, contact.lastName, contact.phoneNumber,
                    contact.email);
        });
    }


}














