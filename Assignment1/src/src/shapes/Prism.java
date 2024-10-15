package src.shapes;

//Prism Interface.

import java.util.Comparator;


public abstract class Prism implements Comparable<Prism>, Comparator<Prism>{
    protected double height;
    protected double side;

    public Prism(double height, double side) {
        this.height = height;
        this.side = side;
    }

    public double getHeight() {
        return height;
    }

    public double getSide() {
        return side;
    }
    
    public abstract double calcBaseArea();
    public abstract double calcVolume();
    
    //Compares the height of the shapes.
    @Override
    public int compareTo(Prism others){
       if (this.getHeight() > others.getHeight()) return 1;
       else if (this.getHeight() < others.getHeight()) return -1;
       else return 0;
    }
    
    //Static functions to compare the baseArea and Volume of the shapes.
    public static Comparator<Prism> baseAreaComparator(){
        return new Comparator<Prism>(){
            @Override
            public int compare(Prism p1, Prism p2){
                return Double.compare(p1.calcBaseArea(), p2.calcBaseArea());
            }
    };
}

    public static Comparator<Prism> volumeComparator(){
        return new Comparator<Prism>(){
            @Override
            public int compare(Prism p1, Prism p2){
                return Double.compare(p1.calcVolume(), p2.calcVolume());
            }
        };
    }

    
}
