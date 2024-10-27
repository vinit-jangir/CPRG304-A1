package src.shapes;

public class TriangularPrism extends Shape
{

    private double side = 0.0;
    
    public TriangularPrism(double height, double side) {
        super(height);
        this.side = side;
    }
    
    @Override
    public double calcBaseArea(){
        return ((side * side * Math.sqrt(3)) / 4);
    }
    
    @Override
    public double calcVolume(){
        return ((side * side * Math.sqrt(3)) / 4) * getHeight();
    }

    @Override
    public String toString(){
        return "TriangularPrism";
    }
}
