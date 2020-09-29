import java.util.ArrayList;
import java.util.Scanner;

public class app
{
    //public static Scanner sc = new Scanner(System.in);
    public static boolean moreInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter 'Y' to continue calculating or 'N' to terminate and average");
        String ans = sc.nextLine(); //hint

        if(ans.equals("Y"))
        {
            return true;
        }/*
        else if(ans.equals("N"))
        {
            return false;
        }*/
        //gives error for some reason
        else
            return false;
    }
    //=================================================================================================

    public static double getUserHeight()
    {
        Scanner sc = new Scanner(System.in);
        double height;
        //loop will keep making user enter height while it is negative
        do {
            System.out.println("Enter height (inches): ");
            height = sc.nextDouble();
        }
        while(height<0);
        return height;
    }
    //=================================================================================================
    public static double getUserWeight()
    {
        Scanner sc = new Scanner(System.in);
        double weight;
        //loop will keep making user enter height while it is negative
        do {
            System.out.println("Enter weight (pounds): ");
            weight = sc.nextDouble();
        }
        while(weight<0);
        return weight;
    }
//==================================================================================================

    public static void displayBmiInfo(BodyMassIndex bmi)
    {
        double result = bmi.bmi;
        System.out.println("The BMI is : " + result);
        //from body mass index class calc
        String category = bmi.category;
        System.out.println("The BMI category is : " + category);
        //from body mass index class category
    }
    //=================================================================================================

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiStat)
    {
        //give running total a starting value to begin adding
        double runningt=0;
        double rounded;
        double average;

        for(int i = 0; i < bmiStat.size(); i++ )
        {
            //will add bmi to running total
            runningt += bmiStat.get(i).bmi;
        }
        //total sum divided the amount of stats
        average = runningt/bmiStat.size();
        rounded = Math.round(average*10.0);
        rounded = rounded/10.0;

        System.out.println("The average is bmi now: "+rounded);
    }
    //=================================================================================================

    //Main provided DO NOT TOUCH!!!!!!

    public static void main(String[] args)
    {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) 
        {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }
        displayBmiStatistics(bmiData);
    }
}
