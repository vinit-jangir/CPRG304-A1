package src.shapes;

public class OctagonalPrism extends Shape
{
    private double side = 0.0;
    public OctagonalPrism(double height, double side) {
        super(height);
        this.side = side;
    }

    // Formula to calculate the base area (A)
    @Override
    public double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * side * side;  
    }

    // Formula to calculate the volume (base area * height)
    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();  
    }
    
    @Override
    public String toString(){
        return "OctagonalPrism";
    }
}
