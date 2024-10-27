package src.shapes;

public class Pyramid extends Shape
{
    private final double SIDE;    

    public Pyramid(double height, double side) {
        super(height);
        this.SIDE = side;
    }
    
    @Override
    public double calcBaseArea(){
        return SIDE * SIDE;
    }
    
    @Override
    public double calcVolume(){
        return (1.0 / 3.0) * SIDE * SIDE * height;
    } 

    @Override
    public String toString(){
        return "Pyramid";
    }
}
