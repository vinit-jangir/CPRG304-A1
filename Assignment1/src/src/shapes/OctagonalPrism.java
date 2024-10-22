package src.shapes;

public class OctagonalPrism extends Shape
{
    private double side;
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
        // Use getHeight() from Shape
        return calcBaseArea() * getHeight();  
    }


    @Override
    public String toString() {
        return "OctagonalPrism [height: " + getHeight() + ", side: " + side + "] ";
    }
}
