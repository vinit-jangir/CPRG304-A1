package src.utilities;

import src.shapes.Shape;

/**
 * Comparator class for comparing shapes based on their base area.
 * This class extends the ShapeComparator abstract class and provides
 * an implementation of the compare method to determine the ordering 
 * of Shape objects by their base area.
 * 
 * @author vinit.jangir
 */
public class AreaComparator extends ShapeComparator {
    
    /**
     * Compares two Shape objects by their base areas.
     *
     * @param shape1 the first Shape object to compare
     * @param shape2 the second Shape object to compare
     * @return a negative integer, zero, or a positive integer as the
     *         first Shape's area is less than, equal to, or greater
     *         than the second Shape's area, respectively.
     */
    @Override
    public int compare(Shape shape1, Shape shape2) {
        // Calculate the base areas of both shapes
        double area1 = shape1.calcBaseArea();
        double area2 = shape2.calcBaseArea();
        
        // Compare areas in descending order
        return Double.compare(area2, area1); 
    }
}