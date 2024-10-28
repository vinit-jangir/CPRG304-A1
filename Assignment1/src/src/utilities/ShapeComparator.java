package src.utilities;

import java.util.Comparator;
import src.shapes.Shape;

/**
 * Abstract base class for comparing shapes.
 * This class implements the Comparator interface for Shape objects.
 * Specific comparison logic should be defined in subclasses.
 * 
 * @author vinit.jangir
 */
public abstract class ShapeComparator implements Comparator<Shape> {
    // This class serves as a foundation for various shape comparison strategies.
    // Concrete subclasses must implement the compare method to provide specific comparison logic.
}