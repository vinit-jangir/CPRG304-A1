package src.appDomain;

import src.shapes.*;
import src.utilities.Reader;
import src.utilities.Sort;

public class AppDriver {

    public static void main(String[] args) {
        
        Cone cone = new Cone(4,3);
        Cylinder cy = new Cylinder(5,7);
        
        System.out.println(cone.compareTo(cy));
        
        System.out.println(cone.compare(cone, cy));
        
        // Define the paths to your shape files
        String[] files = {
            "src/res/shapes1.txt",
            "src/res/shapes2.txt",
            "src/rese/shapes3.txt"
        };

        // Read shapes from the specified files
        Shape[] shapes = Reader.readShapesFromFiles(files);

        // Print the shapes (or do something with them)
        for (Shape shape : shapes) {
            if (shape != null) {
                System.out.println(shape); // Ensure your Shape class has a toString() method for meaningful output
            }
        }
    }
}