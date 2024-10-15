package src.shapes;

public class Cone extends Shape
{
    private double radius;
    private double height;

    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }
    
    @Override
    public double calcBaseArea(){
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calcVolume(){
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }
}
