package src.shapes;

/**
 * Represents a square prism, which is a three-dimensional shape
 * with a square base and a specified height.
 */
public class SquarePrism extends Shape {
    private double side = 0.0; // The length of one side of the square base

    /**
     * Constructor to initialize the square prism with height and side length.
     *
     * @param height The height of the prism.
     * @param side   The length of the side of the square base.
     */
    public SquarePrism(double height, double side) {
        super(height); // Initialize the height in the parent class
        this.side = side; // Set the side length for the square base
    }

    /**
     * Calculates the base area of the square prism.
     *
     * @return The area of the square base.
     */
    @Override
    public double calcBaseArea() {
        return side * side; // Area formula for a square: side * side
    }

    /**
     * Calculates the volume of the square prism.
     *
     * @return The volume calculated as base area times height.
     */
    @Override
    public double calcVolume() {
        return side * side * getHeight(); // Volume formula: base area * height
    }

    /**
     * Returns a string representation of the square prism.
     *
     * @return The name of the shape.
     */
    @Override
    public String toString() {
        return "SquarePrism"; // String representation for the square prism
    }
}