package src.utilities;

import src.shapes.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {

    public static Shape[] FileReader(String fileName) {
        
        Shape[] shapes = null;
        
        try (FileReader fr = new FileReader(fileName); Scanner scanner = new Scanner(fr)) {
            // Read the first line to get the number of shapes
            int shapeCount = scanner.nextInt();
            shapes = new Shape[shapeCount];
            scanner.nextLine();  // Move to the next line after reading shape count
            
            // Read the shapes line by line
            int index = 0;
            while (scanner.hasNextLine() && index < shapeCount) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                String shapeType = tokens[0];
                double height = Double.parseDouble(tokens[1]);
                double radius = Double.parseDouble(tokens[2]);

                // Based on the shape type, create the appropriate shape object
                switch (shapeType) {
                    case "Cylinder":
                        shapes[index] = new Cylinder(height, radius);
                        break;
                    case "Cone":
                        shapes[index] = new Cone(height, radius);
                        break;
                    case "Pyramid":
                        shapes[index] = new Pyramid(height, radius);
                        break;
                    case "OctagonalPrism":
                        shapes[index] = new OctagonalPrism(height, radius);
                        break;
                    case "SquarePrism":
                        shapes[index] = new SquarePrism(height, radius);
                        break;
                    case "TriangularPrism":
                        shapes[index] = new TriangularPrism(height, radius);
                        break;
                    case "PentagonalPrism":
                        shapes[index] = new PentagonalPrism(height, radius);
                        break;
                    default:
                        System.out.println("Unknown shape type: " + shapeType);
                        break;
                }
                index++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return shapes;
    }
}