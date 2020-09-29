public class BodyMassIndex
{
    double bmi;
    String category;

    BodyMassIndex(double height, double weight)
    {
        bmi = bmicalc(weight, height);
        category = bodyMassCat(bmi);
    }

    public double bmicalc(double weight, double height)
    {

        double rBmi= 703 * weight/(height *height);
        rBmi=Math.round(rBmi*10.00);
        rBmi= rBmi/10.00;
        return rBmi;
        //return weight / Math.pow(height, 2) * 703;
        //double bmit = (703 * weight)/(height*height);
        //double rounded = Math.round(bmit)/10.00;
        //return bmit;
    }
    public String bodyMassCat(double bmi)
    {
        String bmiCategory="";

        if(bmi<18.50)
            bmiCategory="Underweight";

        else if(bmi>=18.50 && bmi<=24.90)
            bmiCategory = "Normal";

        else if(bmi>=25.00 && bmi <= 29.90)
            bmiCategory = "Overweight";

        else if(bmi>=30.00)
            bmiCategory = "Obese";

         return bmiCategory;
    }
/*
    BodyMassIndex(double weight, double height)
    {
        bmi = bmicalc(weight, height);
        category = bodyMassCat(bmi);
    }
*/

}
