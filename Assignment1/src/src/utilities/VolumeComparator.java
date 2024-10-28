package src.utilities;

import src.shapes.Shape;

/**
 * Comparator class for comparing shapes based on their volume.
 * This class extends the ShapeComparator abstract class and 
 * provides an implementation of the compare method to determine 
 * the ordering of Shape objects by their volume.
 * 
 * @author vinit.jangir
 */
public class VolumeComparator extends ShapeComparator {
    
    /**
     * Compares two Shape objects by their volumes.
     *
     * @param shape1 the first Shape object to compare
     * @param shape2 the second Shape object to compare
     * @return a negative integer, zero, or a positive integer as the
     *         first Shape's volume is less than, equal to, or greater
     *         than the second Shape's volume, respectively.
     */
    @Override
    public int compare(Shape shape1, Shape shape2) {
        // Calculate volumes for comparison
        double volume1 = shape1.calcVolume();
        double volume2 = shape2.calcVolume();
        
        // Compare volumes in descending order
        return Double.compare(volume2, volume1); 
    }
}