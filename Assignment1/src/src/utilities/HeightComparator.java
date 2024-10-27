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
public class HeightComparator extends ShapeComparator {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape2.getHeight(), shape1.getHeight());
    }

}
