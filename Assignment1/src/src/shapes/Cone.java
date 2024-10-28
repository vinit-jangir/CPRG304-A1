package src.shapes;

/**
 * Represents a Cone shape, extending the Shape class.
 */
public class Cone extends Shape {
    private final double RADIUS; // The radius of the cone's base

    /**
     * Constructor to initialize the Cone with a specific height and radius.
     *
     * @param height The height of the cone.
     * @param radius The radius of the cone's base.
     */
    public Cone(double height, double radius) {
        super(height); // Calls the constructor of the superclass (Shape)
        this.RADIUS = radius; // Sets the radius for this cone
    }
    
    /**
     * Calculates the base area of the cone.
     *
     * @return The base area of the cone.
     */
    @Override
    public double calcBaseArea() {
        return Math.PI * RADIUS * RADIUS; // Area = π * r^2
    }
    
    /**
     * Calculates the volume of the cone.
     *
     * @return The volume of the cone.
     */
    @Override
    public double calcVolume() {
        return (1.0 / 3.0) * Math.PI * RADIUS * RADIUS * height; // Volume = (1/3) * π * r^2 * h
    }
    
    /**
     * Returns a string representation of the cone.
     *
     * @return The name of the shape.
     */
    @Override
    public String toString() {
        return "Cone"; // Returns the type of shape as a string
    }
}