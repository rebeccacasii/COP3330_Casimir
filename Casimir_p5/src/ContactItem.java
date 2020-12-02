public class ContactItem
{
    String firstName, lastName, phoneNumber, email;
    //con
    ContactItem(String firstName, String lastName, String phoneNumber, String email)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
//------------------------------------------------------------------------------------------------------------

    void verify(String firstName, String lastName, String phoneNumber, String email)
    {
        if(firstName.equals("")&&lastName.equals("")&&phoneNumber.equals("")&&email.equals(""))
            throw new IllegalArgumentException();
    }
//------------------------------------------------------------------------------------------------------------

    void setFirstName(String newFirstName)
    {
        this.firstName=newFirstName;
    }
//------------------------------------------------------------------------------------------------------------

    void setLastName(String newlastName)
    {
        this.lastName=newlastName;
    }
//------------------------------------------------------------------------------------------------------------


    void setPhoneNumber(String newPhoneNumber)
    {
        this.phoneNumber=newPhoneNumber;
    }
//------------------------------------------------------------------------------------------------------------

    void setEmail(String newEmail)
    {
        this.email=newEmail;
    }
//------------------------------------------------------------------------------------------------------------

    @Override
    public String toString()
    {
        return(firstName +"\n"+ lastName +"\n"+ phoneNumber +"\n"+ email);
    }
//------------------------------------------------------------------------------------------------------------


}
