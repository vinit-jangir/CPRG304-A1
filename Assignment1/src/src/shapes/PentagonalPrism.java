package src.shapes;

/**
 * Represents a Pentagonal Prism shape, extending the Shape class.
 */
public class PentagonalPrism extends Shape {
    private double side = 0.0; // The length of one side of the pentagonal base

    /**
     * Constructor to initialize the Pentagonal Prism with a specific height and side length.
     *
     * @param height The height of the prism.
     * @param side The length of one side of the pentagonal base.
     */
    public PentagonalPrism(double height, double side) {
        super(height); // Calls the constructor of the superclass (Shape)
        this.side = side; // Sets the side length for this pentagonal prism
    }
    
    /**
     * Calculates the base area of the pentagonal prism.
     *
     * @return The base area of the pentagonal prism.
     */
    @Override
    public double calcBaseArea() {
        return ((5 * side * side * Math.tan(Math.toRadians(54.0))) / 4); // Base area formula for a pentagon
    }
    
    /**
     * Calculates the volume of the pentagonal prism.
     *
     * @return The volume of the pentagonal prism.
     */
    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight(); // Volume = base area * height
    }

    /**
     * Returns a string representation of the pentagonal prism.
     *
     * @return The name of the shape.
     */
    @Override
    public String toString() {
        return "PentagonalPrism"; // Returns the type of shape as a string
    }
}