package src.shapes;

/**
 * Represents a triangular prism, which is a three-dimensional shape
 * with a triangular base and a specified height.
 */
public class TriangularPrism extends Shape {

    private double side = 0.0; // The length of one side of the triangular base

    /**
     * Constructor to initialize the triangular prism with height and side length.
     *
     * @param height The height of the prism.
     * @param side   The length of the side of the triangular base.
     */
    public TriangularPrism(double height, double side) {
        super(height); // Initialize the height in the parent class
        this.side = side; // Set the side length for the triangular base
    }

    /**
     * Calculates the base area of the triangular prism.
     *
     * @return The area of the triangular base.
     */
    @Override
    public double calcBaseArea() {
        return ((side * side * Math.sqrt(3)) / 4); // Area formula for an equilateral triangle
    }

    /**
     * Calculates the volume of the triangular prism.
     *
     * @return The volume calculated as base area times height.
     */
    @Override
    public double calcVolume() {
        return ((side * side * Math.sqrt(3)) / 4) * getHeight(); // Volume formula: base area * height
    }

    /**
     * Returns a string representation of the triangular prism.
     *
     * @return The name of the shape.
     */
    @Override
    public String toString() {
        return "TriangularPrism"; // String representation for the triangular prism
    }
}