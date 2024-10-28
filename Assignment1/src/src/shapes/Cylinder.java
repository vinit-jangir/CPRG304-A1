package src.shapes;

/**
 * Represents a Cylinder shape, extending the Shape class.
 */
public class Cylinder extends Shape {
    private final double RADIUS; // The radius of the cylinder's base

    /**
     * Constructor to initialize the Cylinder with a specific height and radius.
     *
     * @param height The height of the cylinder.
     * @param radius The radius of the cylinder's base.
     */
    public Cylinder(double height, double radius) {
        super(height); // Calls the constructor of the superclass (Shape)
        this.RADIUS = radius; // Sets the radius for this cylinder
    }
    
    /**
     * Calculates the base area of the cylinder.
     *
     * @return The base area of the cylinder.
     */
    @Override
    public double calcBaseArea() {
        return Math.PI * RADIUS * RADIUS; // Area = π * r^2
    }
    
    /**
     * Calculates the volume of the cylinder.
     *
     * @return The volume of the cylinder.
     */
    @Override
    public double calcVolume() {
        return Math.PI * RADIUS * RADIUS * height; // Volume = π * r^2 * h
    }
    
    /**
     * Returns a string representation of the cylinder.
     *
     * @return The name of the shape.
     */
    @Override
    public String toString() {
        return "Cylinder"; // Returns the type of shape as a string
    }
}