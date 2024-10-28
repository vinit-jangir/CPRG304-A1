package src.shapes;

/**
 * Represents a Pyramid shape, extending the Shape class.
 */
public class Pyramid extends Shape {
    private final double SIDE; // The length of one side of the square base

    /**
     * Constructor to initialize the Pyramid with a specific height and side length.
     *
     * @param height The height of the pyramid.
     * @param side The length of one side of the square base.
     */
    public Pyramid(double height, double side) {
        super(height); // Calls the constructor of the superclass (Shape)
        this.SIDE = side; // Sets the side length for this pyramid
    }
    
    /**
     * Calculates the base area of the pyramid.
     *
     * @return The base area of the pyramid.
     */
    @Override
    public double calcBaseArea() {
        return SIDE * SIDE; // Base area formula for a square
    }
    
    /**
     * Calculates the volume of the pyramid.
     *
     * @return The volume of the pyramid.
     */
    @Override
    public double calcVolume() {
        return (1.0 / 3.0) * SIDE * SIDE * getHeight(); // Volume = (1/3) * base area * height
    } 

    /**
     * Returns a string representation of the pyramid.
     *
     * @return The name of the shape.
     */
    @Override
    public String toString() {
        return "Pyramid"; // Returns the type of shape as a string
    }
}