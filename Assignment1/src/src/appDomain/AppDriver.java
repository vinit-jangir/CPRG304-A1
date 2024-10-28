package src.appDomain;

import src.shapes.Shape;
import src.utilities.*;
import java.util.Comparator;

/**
 * AppDriver is the main class for executing the shape sorting application.
 * This application reads shape data from a specified file, sorts the shapes
 * based on user-defined criteria, and prints the sorted results.
 * 
 * Authors: Vinit Jangir, Tan Phu Nguyen, Joseph Bui
 * Date: 2024-10-28
 *
 * Parameters:
 * -f <filename>: Specifies the file containing shape data.
 * -t <criteria>: Specifies the comparison criteria (h: height, a: area, v: volume).
 * -s <method>: Specifies the sorting method (b: bubble, s: selection, i: insertion,
 *               m: merge, q: quick, g: gnome).
 */
public class AppDriver {
    public static void main(String[] args) {
        // Check if the user provided enough command-line arguments
        if (args.length < 3) {
            System.out.println("Error: Invalid arguments");
            return;
        }

        // Variables to store command-line argument values
        String fileName = "";         // Name of the file to read shapes from
        String compareCriteria = "";   // Criteria for comparing shapes
        String sortMethod = "";        // Sorting method to be used

        // Iterate through command-line arguments to parse options
        for (String arg : args) {
            // Check if the argument is for the filename
            if (arg.toLowerCase().startsWith("-f")) {
                // Extract the filename and remove surrounding quotes if present
                fileName = arg.substring(2).replaceAll("^\"|\"$", "");
            } 
            // Check if the argument is for the comparison criteria
            else if (arg.toLowerCase().startsWith("-t")) {
                // Extract and convert the criteria to lowercase
                compareCriteria = arg.substring(2).toLowerCase();
            } 
            // Check if the argument is for the sorting method
            else if (arg.toLowerCase().startsWith("-s")) {
                // Extract and convert the method to lowercase
                sortMethod = arg.substring(2).toLowerCase();
            }
        }

        // Validate that required arguments are provided
        if (fileName.isEmpty() || compareCriteria.isEmpty() || sortMethod.isEmpty()) {
            System.out.println("Error: Missing required arguments.");
            return;
        }

        // Read shapes from the specified file using a utility method
        Shape[] shapes = Reader.FileReader(fileName);

        // Check if the shapes were successfully read from the file
        if (shapes == null || shapes.length == 0) {
            System.out.println("Error: Unable to read shapes from file.");
            return;
        }

        // Determine the appropriate comparator based on the user's criteria
        Comparator<Shape> comparator;
        switch (compareCriteria) {
            case "h":
                comparator = new HeightComparator(); // Compare by height
                break;
            case "a":
                comparator = new AreaComparator();   // Compare by area
                break;
            case "v":
                comparator = new VolumeComparator(); // Compare by volume
                break;
            default:
                System.out.println("Error: Invalid comparison criteria.");
                return; // Exit if criteria is invalid
        }

        // Create an instance of the Sort class with the selected comparator
        Sort<Shape> sorter = new Sort<>(comparator);

        // Record the start time for sorting performance measurement
        long startTime = System.nanoTime();

        // Sort shapes using the specified method
        switch (sortMethod) {
            case "b":
                sorter.bubbleSort(shapes); // Perform bubble sort
                break;
            case "s":
                sorter.selectionSort(shapes); // Perform selection sort
                break;
            case "i":
                sorter.insertionSort(shapes); // Perform insertion sort
                break;
            case "m":
                sorter.mergeSort(shapes); // Perform merge sort
                break;
            case "q":
                sorter.quickSort(shapes); // Perform quick sort
                break;
            case "g":
                sorter.gnomeSort(shapes); // Perform gnome sort
                break;    
            default:
                System.out.println("Error: Invalid sorting method.");
                return; // Exit if sorting method is invalid
        }
        
        // Record the end time for sorting performance measurement
        long endTime = System.nanoTime();

        // Print details of shapes based on the specified criteria
        if (shapes.length > 0) {
            shapeKind(shapes[0], compareCriteria, "First"); // Print first shape
        }

        // Loop through and print details of the shapes
        for (int i = 1; i < shapes.length - 1; i++) {
            shapeKind(shapes[i], compareCriteria, (i + 1) + "000-th"); // Print shape details
            try {
                Thread.sleep(100); // Delay of 100 milliseconds between prints
            } catch (InterruptedException e) {
                System.out.println("An error occurred during sleep.");
            }
        }

        // Print second last and last shape details based on criteria
        if (shapes.length > 1) {
            shapeKind(shapes[shapes.length - 2], compareCriteria, "Second last");
        }
        if (shapes.length > 0) {
            shapeKind(shapes[shapes.length - 1], compareCriteria, "Last");
        }

        // Calculate and print the time taken for sorting in milliseconds
        long timeTaken = endTime - startTime;
        System.out.println(sortMethod + " run time was: " + timeTaken + " milliseconds");
    }

    /**
     * Prints details of a shape based on the specified criteria and position.
     *
     * @param shape The shape object to print details for.
     * @param criteria The criteria used for comparison (height, area, volume).
     * @param position A string indicating the position of the shape in the output.
     */
    private static void shapeKind(Shape shape, String criteria, String position) {
        String details = ""; // Variable to hold shape details
        // Determine shape details based on criteria
        switch (criteria) {
            case "h":
                details = shape + " has a Height of: " + shape.getHeight();
                break;
            case "a":
                details = shape + " has an Area of: " + shape.calcBaseArea();
                break;
            case "v":
                details = shape + " has a Volume of: " + shape.calcVolume();
                break;
        }
        // Print the details of the shape
        System.out.println(position + " element is: " + details);
    }
}