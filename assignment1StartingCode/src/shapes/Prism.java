package shapes;

//Prism Interface.

public abstract class Prism implements Comparable<Prism>{
    private double height;
    private double side;

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
    
    @Override
    public int compareTo(Prism others){
       if (this.getHeight() > others.getHeight()) return 1;
       else if (this.getHeight() < others.getHeight()) return -1;
       else return 0;
    }

    
}
