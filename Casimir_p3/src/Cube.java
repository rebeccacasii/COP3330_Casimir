public class Cube extends Shape3D
{
    private double sL;
    public Cube(double sL)
    {
        this.sL=sL;
    }

    @Override
    public double getVolume() {
        return sL*sL*sL;
    }

    @Override
    public String getName()
    {
        return "cube";
    }

    @Override
    public double getArea()
    {
        return 6.00*sL*sL;
    }
}
