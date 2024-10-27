package src.shapes;

public class Cone extends Shape
{
    private final double RADIUS;

    public Cone(double height, double radius) {
        super(height);
        this.RADIUS = radius;
    }
    
    @Override
    public double calcBaseArea(){
        return Math.PI * RADIUS * RADIUS;
    }
    
    @Override
    public double calcVolume(){
        return (1.0 / 3.0) * Math.PI * RADIUS * RADIUS * height;
    }
    
    @Override
    public String toString(){
        return "Cone";
    }
}
