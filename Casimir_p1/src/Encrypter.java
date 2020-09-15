public class Encrypter
{

    //1 method to encrypt
    public String encrypt(String input)
    {
        //String code = null;
        String code = "";

        for(int i = 0; i < input.length(); i++ )
        {
            int j;
            int res;

            //in java this returns an integer giving a string representation of decimal(parseInt)
            j = Integer.parseInt(input.charAt(i)+"")+ 7;
            res = j%10;

            code = code + res;
        }

        // swap the first with third and second digit with fourth digit
        char temp;
        char a = code.charAt(0);
        char b= code.charAt(1);
        char c = code.charAt(2);
        char d = code.charAt(3);

        temp = a;
        a = c;
        c = temp;

        temp = b;
        b = d;
        d = temp;

        String encrypted = a + ""+ b+ "" + c+""+ d+"";
        return encrypted;

    }
}
