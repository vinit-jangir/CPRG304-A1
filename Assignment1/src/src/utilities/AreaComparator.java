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
public class AreaComparator extends ShapeComparator {
    
    @Override
    public int compare(Shape shape1, Shape shape2) {
        double area1 = shape1.calcBaseArea();
        double area2 = shape2.calcBaseArea();
        return Double.compare(area1, area2);
    }
}
