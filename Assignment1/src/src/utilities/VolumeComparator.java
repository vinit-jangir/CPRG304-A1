/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.utilities;

import src.shapes.Shape;

/**
 *
 * @author vinit.jangir
 */
public class VolumeComparator extends ShapeComparator {
    
    @Override
    public int compare(Shape shape1, Shape shape2) {
        double volume1 = shape1.calcVolume();
        double volume2 = shape2.calcVolume();
        return Double.compare(volume2, volume1); 
    }
}
