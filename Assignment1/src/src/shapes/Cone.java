package src.shapes;

public class Cone extends Shape
{
    private double radius;

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
    
    @Override
    public int compare(Shape s1, Shape s2){
                return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
    }
}
