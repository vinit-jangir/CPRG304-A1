package src.shapes;

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape>{
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
    
    @Override
    public int compareTo(Shape others){
       if (this.getHeight() > others.getHeight()) return 1;
       else if (this.getHeight() < others.getHeight()) return -1;
       else return 0; 
       
       //return Double.compare(this.getHeight(),others.getHeight());
    }   
    
    //Static Methods
    public static Comparator<Shape> baseAreaComperator(){
        return new Comparator<Shape>(){
            @Override
            public int compare(Shape s1, Shape s2){
                return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
            }
        };
    }
    
    public static Comparator<Shape> volumeComperator(){
        return new Comparator<Shape>(){
            @Override
            public int compare(Shape s1, Shape s2){
                return Double.compare(s1.calcVolume(), s2.calcVolume());
            }
        };
    }

}
    
   

