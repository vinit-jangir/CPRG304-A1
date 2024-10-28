package src.utilities;

import src.shapes.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Reader class for loading shapes from a file.
 * This class provides functionality to read shape data from a 
 * specified file and instantiate the corresponding shape objects.
 */
public class Reader {

    /**
     * Reads shapes from the specified file and creates an array of Shape objects.
     *
     * The first line of the file should contain the number of shapes,
     * followed by lines representing each shape with its type, height, 
     * and radius. The method will create instances of the shapes 
     * based on the data read from the file.
     *
     * @param fileName the name of the file to read shapes from
     * @return an array of Shape objects populated from the file, or null if an error occurs
     */
    public static Shape[] FileReader(String fileName) {
        
        Shape[] shapes = null; // Array to hold Shape objects
        
        try (FileReader fr = new FileReader(fileName); Scanner scanner = new Scanner(fr)) {
            // Read the first line to get the number of shapes
            int shapeCount = scanner.nextInt();
            shapes = new Shape[shapeCount]; // Initialize the array for the shapes
            scanner.nextLine();  // Move to the next line after reading shape count
            
            // Read the shapes line by line
            int index = 0;
            while (scanner.hasNextLine() && index < shapeCount) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" "); // Split the line into tokens
                String shapeType = tokens[0]; // First token indicates the shape type
                double height = Double.parseDouble(tokens[1]); // Second token is height
                double radius = Double.parseDouble(tokens[2]); // Third token is radius

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
                        // Print a warning for unknown shape types
                        System.out.println("Unknown shape type: " + shapeType);
                        break;
                }
                index++; // Increment index for the next shape
            }
        } catch (IOException e) {
            // Handle potential IO exceptions
            System.err.println("Error reading file: " + e.getMessage());
        }
        return shapes; // Return the array of shapes
    }
}