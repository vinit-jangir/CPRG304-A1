package src.shapes;

/**
 * Represents an Octagonal Prism shape, extending the Shape class.
 */
public class OctagonalPrism extends Shape {
    private double side = 0.0; // The length of one side of the octagonal base

    /**
     * Constructor to initialize the Octagonal Prism with a specific height and side length.
     *
     * @param height The height of the prism.
     * @param side The length of one side of the octagonal base.
     */
    public OctagonalPrism(double height, double side) {
        super(height); // Calls the constructor of the superclass (Shape)
        this.side = side; // Sets the side length for this octagonal prism
    }

    /**
     * Calculates the base area of the octagonal prism.
     *
     * @return The base area of the octagonal prism.
     */
    @Override
    public double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * side * side; // Base area formula for an octagon
    }

    /**
     * Calculates the volume of the octagonal prism.
     *
     * @return The volume of the octagonal prism.
     */
    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight(); // Volume = base area * height
    }
    
    /**
     * Returns a string representation of the octagonal prism.
     *
     * @return The name of the shape.
     */
    @Override
    public String toString() {
        return "OctagonalPrism"; // Returns the type of shape as a string
    }
}