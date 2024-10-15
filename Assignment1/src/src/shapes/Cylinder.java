package src.shapes;

public class Cylinder extends Shape{
    private double radius;
    private double height;
    
    public Cylinder(double height, double radius){
        super(height);
        this.radius = radius;
    }
    
    @Override
    public double calcBaseArea(){
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calcVolume(){
        return Math.PI * radius * radius * height;
    }
}
