package src.shapes;

public class SquarePrism extends Prism
{
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
    
    @Override
    public String toString(){
        return "Square Prism ";
    }
}
