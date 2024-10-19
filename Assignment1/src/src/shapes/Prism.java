package src.shapes;

//Prism Interface.

import java.util.Comparator;


public abstract class Prism implements Comparable<Prism>{
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
       return Double.compare(this.getHeight(), others.getHeight());
    }

    // Comparator to sort by base area for Prism types
    public static Comparator<Prism> BaseAreaComparator = new Comparator<Prism>() {
        @Override
        public int compare(Prism prism1, Prism prism2) {
            return Double.compare(prism1.calcBaseArea(), prism2.calcBaseArea());
        }
    };

    // Comparator to sort by volume for Prism types
    public static Comparator<Prism> VolumeComparator = new Comparator<Prism>() {
        @Override
        public int compare(Prism prism1, Prism prism2) {
            return Double.compare(prism1.calcVolume(), prism2.calcVolume());
        }
    };

    
}
