import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest
{
    @Test
    void underweightBmi()
    {
        BodyMassIndex b= new BodyMassIndex(39,36.5);
        assertEquals(16.9, b.bmi);
    }

    @Test
    void NormalBmi()
    {
        BodyMassIndex b= new BodyMassIndex(66,140);
        assertEquals(22.6, b.bmi);
    }

    @Test
    void overweightBmi()
    {
        BodyMassIndex b= new BodyMassIndex(60,140);
        assertEquals(27.3, b.bmi);
    }

    @Test
    void obeseBmi()
    {
        BodyMassIndex b= new BodyMassIndex(65,200);
        assertEquals(33.3, b.bmi);
    }

    @Test
    void calcbmitest()
    {
        BodyMassIndex b= new BodyMassIndex(66,150);
        double bmit = b.bmicalc(150,66);
        assertEquals(24.2, bmit);
    }

    @Test
    void getcattest()
    {
        BodyMassIndex b= new BodyMassIndex(66,150);
        double bmiz= b.bmi;
        String cate = b.bodyMassCat(bmiz);
        assertEquals(cate, "Normal");
    }


}
