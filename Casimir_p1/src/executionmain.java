import java.util.Scanner;

public class executionmain
{
    public static void main(String[] args)
    {
    Scanner func = new Scanner(System.in);
    String input;

    //do while loop to ensure that user enters a 4 digit
        //length takes length of string
    do {
        System.out.print("Enter four digit data: ");
        input = func.nextLine();
    }while( input.length() != 4);


    //Create Encrypter
    Encrypter my = new Encrypter();
    String encrypt = my.encrypt(input);
    System.out.println( "Encrypted value : " +encrypt);

    //Create Decrypter
    Decrypter og = new Decrypter();
    String decrpt = og.decrypt(encrypt);
    System.out.println("Decrypted value : " +decrpt);
    }

}
