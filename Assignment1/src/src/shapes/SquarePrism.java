package src.shapes;

public class SquarePrism extends Shape
{
    private double side = 0.0;
    
    public SquarePrism(double height, double side) {
        super(height);
        this.side = side;
    }
    
    @Override
    public double calcBaseArea(){
        return side * side;
    }
    
    @Override
    public double calcVolume(){
        return side * side * getHeight();
    }
    
    @Override
    public String toString(){
        return "SquarePrism";
    }
}
