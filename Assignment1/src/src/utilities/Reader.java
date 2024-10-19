package src.utilities;

import src.shapes.Shape;
import src.shapes.Prism;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    // Method to read shapes from files and store them in a single array
    public static Shape[] readShapesFromFiles(String[] fileNames) {
        int totalShapes = 0;

        // First pass: Count total shapes
        for (String fileName : fileNames) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                while (br.readLine() != null) {
                    totalShapes++; // Increment count for each line (shape)
                }
            } catch (IOException e) {
                System.err.println("Error reading file " + fileName + ": " + e.getMessage());
            }
        }

        // Create an array to hold all shapes
        Shape[] shapes = new Shape[totalShapes];
        int currentIndex = 0;

        // Second pass: Read shapes into the array
        for (String fileName : fileNames) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    shapes[currentIndex] = createShapeFromLine(line);
                    currentIndex++;
                }
            } catch (IOException e) {
                System.err.println("Error reading file " + fileName + ": " + e.getMessage());
            }
        }

        return shapes; // Return the array of shapes
    }

    // Method to create Shape or Prism based on the input line
    private static Shape createShapeFromLine(String line) {
        String[] parts = line.split(","); // Assuming data is comma-separated
        String shapeType = parts[0].trim();

        switch (shapeType.toLowerCase()) {
            case "prism":
                // Parse prism parameters (for example: height, baseArea)
                double height = Double.parseDouble(parts[1].trim());
                double baseArea = Double.parseDouble(parts[2].trim());
                //return new Prism(height, baseArea); // Create Prism instance

            case "shape":
                // Parse shape parameters (for example: height)
                height = Double.parseDouble(parts[1].trim());
                //return new Shape(height); // Create Shape instance

            default:
                System.err.println(shapeType);
                return null;
        }
    }
}