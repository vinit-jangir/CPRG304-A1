package src.appDomain;

import src.shapes.Shape;
import src.utilities.*;
import java.util.Comparator;

public class AppDriver {

    public static void main(String[] args) {
        if(args.length < 3) {
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
            System.out.println("Usage: java -jar Sort.jar -ffile_name -tv -sb");
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
            case "z":
                // No operation
                break;
            default:
                System.out.println("Error: Invalid sorting method. Use 'b', 's', 'i', 'm', 'q', or 'z'.");
                return;
        }


        System.out.println("\nSorted Shapes:");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}




//Need an big O on log(n) for - for giving the 1000th lines. and Space Complexity
