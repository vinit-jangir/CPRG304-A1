package src.shapes;

public class SquarePrism extends Prism
{
    private double side;
    private double height;
    
    public SquarePrism(double height, double side) {
        super(height, side);
    }
    
    @Override
    public double calcBaseArea(){
        return side * side;
    }
    
    @Override
    public double calcVolume(){
        return side * side * height;
    }
}