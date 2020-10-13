public class Pyramid extends Shape3D
{
    private double baselength;
    private double width;
    private double height;
//constructor
    public Pyramid(double baselength, double width, double height)
    {
        this.baselength = baselength;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getVolume()
    {
        return baselength*width*height/3.00;
    }

    @Override
    public String getName()
    {
        return "pyramid";
    }

    @Override
    public double getArea()
    {
        //double sideLength = Math.sqrt(height * height
                //+ baselength * baselength / 4.00);

        return (baselength * width) + (baselength * Math.sqrt(Math.pow(width / 2, 2) +
                Math.pow(height, 2))) + (width * Math.sqrt(Math.pow(baselength / 2, 2) + Math.pow(height, 2)));
    }
}
