package src.shapes;

public abstract class Shape{
    protected double height;

    public Shape(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public abstract double calcBaseArea();
    public abstract double calcVolume();  
}