public class Decrypter
{
    //this is basically the same code as encrypter with few changes
    //only 1 method
    public String decrypt(String input)
    {
        String code = "";
        for(int i = 0 ; i < input.length() ; i++ )
        {
            int res = (Integer.parseInt(input.charAt(i)+""));
            int j = res-7;
            if (j < 0)
            { //to revert properly
                j += 10;
            }
            code = code + j;
        }

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

        String decrypted = a + ""+ b+ "" + c+""+ d+"";
        return decrypted;
    }

}
