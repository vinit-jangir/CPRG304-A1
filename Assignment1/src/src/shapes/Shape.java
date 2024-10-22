package src.shapes;

import java.util.Comparator;

//Remove Prism.java and put all the shapes here



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