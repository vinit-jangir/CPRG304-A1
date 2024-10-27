package src.shapes;

public class PentagonalPrism extends Shape
{
    private double side = 0.0;
    
    public PentagonalPrism(double height, double side) {
        super(height);
        this.side = side;
    }
    
    @Override
    public double calcBaseArea(){
        return ((5 * side * side * Math.tan(Math.toRadians(54.0))) / 4);
    }
    
    @Override
    public double calcVolume(){
        return ((5 * side * side * Math.tan(Math.toRadians(54.0))) / 4) * getHeight();
    }

    @Override
    public String toString(){
        return "PentagonalPrism";
    }
}
