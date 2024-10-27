package src.shapes;

public class Cylinder extends Shape{
    private final double RADIUS;
    
    public Cylinder(double height, double radius){
        super(height);
        this.RADIUS = radius;
    }
    
    @Override
    public double calcBaseArea(){
        return Math.PI * RADIUS * RADIUS;
    }
    
    @Override
    public double calcVolume(){
        return Math.PI * RADIUS * RADIUS * height;
    }
    
    @Override
    public String toString(){
        return "Cylinder";
    }
}
