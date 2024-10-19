package src.shapes;

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape>, Comparator<Shape> {
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

    // Implementing the Comparable interface to compare by height
    @Override
    
    public int compareTo(Shape others) {
        return Double.compare(this.getHeight(), others.getHeight());
    }

    //comparing baseArea
    public int compare(Shape s1, Shape s2) {
    double area1 = s1.calcBaseArea();
    double area2 = s2.calcBaseArea();

    

    int comparisonResult = Double.compare(area1, area2);

    if (comparisonResult > 0) {
        System.out.println("The Area of "  + s1.toString() + area1 + " has greater than the Area of " + s2.toString() + area2 );
    } else if (comparisonResult < 0) {
        System.out.println("The Area of "  + s1.toString() + area1 + " has less than the Area of " + s2.toString() + area2 );
    } else {
        System.out.println("The Area of "  + s1.toString() + area1 + " has same the Area as " + s2.toString() + area2 );
    }

    return comparisonResult;
}
    
    //Comparing by Volume
    //public int comparebyVolume(Shape s1, Shape s2){
    //    return Double.compare(s1.calcVolume(), s2.calcVolume());
    //}
        
    
}