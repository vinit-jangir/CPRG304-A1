package src.shapes;

public class TriangularPrism extends Shape
{

    private double side;
    
    public TriangularPrism(double height, double side) {
        super(height);
        this.side = side;
    }
    
    //formaula to calculate base.
    private double base_area = ((side * side * Math.sqrt(3)) / 4);
    
    @Override
    public double calcBaseArea(){
        return base_area;
    }
    
    @Override
    public double calcVolume(){
        return base_area * height;
    }

    @Override
    public String toString(){
        return "TriangularPrism [height: " + getHeight() + ", side: " + side + "] ";
    }
}
