package src.shapes;


public abstract class Shape implements Comparable<Shape>{
    private double height;

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
    }
}

