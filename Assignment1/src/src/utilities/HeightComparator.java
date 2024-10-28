package src.utilities;

import src.shapes.Shape;

/**
 * Comparator class for comparing shapes based on their height.
 * This class extends the ShapeComparator abstract class and 
 * provides an implementation of the compare method to determine 
 * the ordering of Shape objects by their height.
 * 
 * @author vinit.jangir
 */
public class HeightComparator extends ShapeComparator {
    
    /**
     * Compares two Shape objects by their heights.
     *
     * @param shape1 the first Shape object to compare
     * @param shape2 the second Shape object to compare
     * @return a negative integer, zero, or a positive integer as the
     *         first Shape's height is less than, equal to, or greater
     *         than the second Shape's height, respectively.
     */
    @Override
    public int compare(Shape shape1, Shape shape2) {
        // Compare heights in descending order
        return Double.compare(shape2.getHeight(), shape1.getHeight());
    }
}