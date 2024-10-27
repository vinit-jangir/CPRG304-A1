package src.shapes;

public class PentagonalPrism extends Shape
{
    private double side = 0.0;
    
    public PentagonalPrism(double height, double side) {
        super(height);
        this.side = side;
    }
    
    //Formaulae to be calculated
    private double tan = Math.tan(Math.toRadians(54.0));    //tan(54 degree) -< we need to change it to radian.
    protected double base_area = ((5 * side * side * tan) / 4);
    
    @Override
    public double calcBaseArea(){
        return base_area;
    }
    
    @Override
    public double calcVolume(){
        return base_area * getHeight();
    }

    @Override
    public String toString(){
        return "PentagonalPrism";
    }
}
