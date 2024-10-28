package src.appDomain;

import src.shapes.Shape;
import src.utilities.*;
import java.util.Comparator;

public class AppDriver {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: Invalid arguments");
            return;
        }

        String fileName = "";
        String compareCriteria = "";
        String sortMethod = "";

        for (String arg : args) {
            if (arg.toLowerCase().startsWith("-f")) {
                fileName = arg.substring(2);
                if (fileName.startsWith("\"") && fileName.endsWith("\"")) {
                    fileName = fileName.substring(1, fileName.length() - 1);
                }
            } else if (arg.toLowerCase().startsWith("-t")) {
                compareCriteria = arg.substring(2).toLowerCase();
            } else if (arg.toLowerCase().startsWith("-s")) {
                sortMethod = arg.substring(2).toLowerCase();
            }
        }

        if (fileName.isEmpty() || compareCriteria.isEmpty() || sortMethod.isEmpty()) {
            System.out.println("Error: Missing required arguments.");
            return;
        }

        // Read shapes from the specified file
        Shape[] shapes = Reader.FileReader(fileName);

        if (shapes == null || shapes.length == 0) {
            System.out.println("Error: Unable to read shapes from file.");
            return;
        }

        Comparator<Shape> comparator = null;
        switch (compareCriteria) {
            case "h":
                comparator = new HeightComparator();
                break;
            case "a":
                comparator = new AreaComparator();
                break;
            case "v":
                comparator = new VolumeComparator();
                break;
            default:
                System.out.println("Error: Invalid comparison criteria. Use 'h' for height, 'a' for area, or 'v' for volume.");
                return;
        }

        // Create an instance of Sort with the comparator
        Sort<Shape> sorter = new Sort<>(comparator);

        long startTime = System.nanoTime();

        switch (sortMethod) {
            case "b":
                sorter.bubbleSort(shapes);
                break;
            case "s":
                sorter.selectionSort(shapes);
                break;
            case "i":
                sorter.insertionSort(shapes);
                break;
            case "m":
                sorter.mergeSort(shapes);
                break;
            case "q":
                sorter.quickSort(shapes);
                break;
            case "g":
                sorter.gnomeSort(shapes);
                break;    
            default:
                System.out.println("Error: Invalid sorting method. Use 'b', 's', 'i', 'm', 'q', or 'g'.");
                return;
        }
        long endTime = System.nanoTime();

        // Print the first element based on -t criteria
        if (shapes.length > 0) {
            shapeKind(shapes[0], compareCriteria, "First");
        }

        for (int i = 1; i <shapes.length - 2; i++) {
            shapeKind(shapes[i], compareCriteria, (i + 1) + "000-th");
            try {
                // Delay of 1 second (1000 milliseconds) between each print
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("An error occurred during sleep.");
            }
        }

        // Print the second-last element based on -t criteria
        if (shapes.length > 1) {
            shapeKind(shapes[shapes.length - 2], compareCriteria, "Second last");
        }

        // Print the last element based on -t criteria
        if (shapes.length > 0) {
            shapeKind(shapes[shapes.length - 1], compareCriteria, "Last");
        }

        // Print time taken by the sorting algorithm in nanoseconds
        long time = endTime - startTime;
        int timeTaken = (int) time;
        System.out.println(sortMethod + " run time was: " + timeTaken + " milliseconds");
    }

    // Helper method to print shape details based on criteria
    private static void shapeKind(Shape shape, String criteria, String position) {
        String details = "";
        switch (criteria) {
            case "h":
                details = shape + " has a Height of: " + shape.getHeight();
                break;
            case "a":
                details = shape + " has a Area of: " + shape.calcBaseArea();
                break;
            case "v":
                details = shape + " has a Volume of: " + shape.calcVolume();
                break;
        }
        System.out.println(position + " element is: " + details);
    }
}