package src.shapes;

/**
 * Abstract class representing a geometric shape.
 * This class serves as a base for specific shape implementations, providing
 * common properties and methods related to shape dimensions.
 */
public abstract class Shape {
    protected double height; // The height of the shape

    /**
     * Constructor to initialize the height of the shape.
     *
     * @param height The height of the shape.
     */
    public Shape(double height) {
        this.height = height; // Sets the height for this shape
    }

    /**
     * Retrieves the height of the shape.
     *
     * @return The height of the shape.
     */
    public double getHeight() {
        return height; // Returns the height of the shape
    }

    /**
     * Sets a new height for the shape.
     *
     * @param height The new height of the shape.
     */
    public void setHeight(double height) {
        this.height = height; // Updates the height of the shape
    }

    /**
     * Abstract method to calculate the base area of the shape.
     * This method must be implemented by subclasses.
     *
     * @return The base area of the shape.
     */
    public abstract double calcBaseArea();

    /**
     * Abstract method to calculate the volume of the shape.
     * This method must be implemented by subclasses.
     *
     * @return The volume of the shape.
     */
    public abstract double calcVolume();
}