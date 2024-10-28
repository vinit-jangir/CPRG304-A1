package src.utilities;

import src.shapes.Shape;
import java.util.Comparator;

// Sorting Class to keep all the sorting methods.
public class Sort<T extends Shape> {

    private final Comparator<T> COMPARATOR;

    // Constructor to initialize the COMPARATOR
    public Sort(Comparator<T> comparator) {
        this.COMPARATOR = comparator;
    }

    // Bubble Sort with Early Exit Optimization
    public void bubbleSort(T[] shapes) {
        int n = shapes.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap if needed
                if (COMPARATOR.compare(shapes[j], shapes[j + 1]) > 0) {
                    swap(shapes, j, j + 1);
                    swapped = true;
                }
            }

            // Exit early if no elements were swapped
            if (!swapped) break;
        }
    }

    // Selection Sort
    public void selectionSort(T[] shapes) {
        int n = shapes.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (COMPARATOR.compare(shapes[j], shapes[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            swap(shapes, i, minIndex);
        }
    }
    
    // Insertion Sort using a for loop
    public void insertionSort(T[] shapes) {
        int n = shapes.length;

        for (int i = 1; i < n; i++) {
            T key = shapes[i];
            int j;

            // Shift elements of the sorted section that are greater than the key
            for (j = i - 1; j >= 0 && COMPARATOR.compare(shapes[j], key) > 0; j--) {
                shapes[j + 1] = shapes[j];
            }

            // Insert the key at the correct position in the sorted section
            shapes[j + 1] = key;
        }
    }

    // Merge Sort using for loops
    public void mergeSort(T[] shapes) {
        if (shapes.length < 2) return;
        int mid = shapes.length / 2;

        T[] left = (T[]) new Shape[mid];
        T[] right = (T[]) new Shape[shapes.length - mid];

        System.arraycopy(shapes, 0, left, 0, mid);
        System.arraycopy(shapes, mid, right, 0, shapes.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(shapes, left, right);
    }

    private void merge(T[] shapes, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        // Use a for loop to merge elements from left and right arrays
        for (int n = left.length + right.length; k < n; k++) {
            if (i < left.length && j < right.length) {
                // Choose the smaller element from left or right array
                if (left[i] != null && right[j] != null &&
                    COMPARATOR.compare(left[i], right[j]) <= 0) {
                    shapes[k] = left[i];
                    i++;
                } else {
                    shapes[k] = right[j];
                    j++;
                }
            } else if (i < left.length) { // Only elements in left array remain
                shapes[k] = left[i];
                i++;
            } else { // Only elements in right array remain
                shapes[k] = right[j];
                j++;
            }
        }
    }
    
    // Quick Sort
    public void quickSort(T[] shapes) {
        quickSort(shapes, 0, shapes.length - 1);
    }

    private void quickSort(T[] shapes, int low, int high) {
        if (low < high) {
            int pi = partition(shapes, low, high);
            quickSort(shapes, low, pi - 1);  // Recursively sort elements before partition
            quickSort(shapes, pi + 1, high); // Recursively sort elements after partition
        }
    }

    private int partition(T[] shapes, int low, int high) {
        T pivot = shapes[high]; // Choose the last element as pivot
        int i = low - 1; // Pointer for the smaller element

        for (int j = low; j < high; j++) {
            if (shapes[j] != null && pivot != null && COMPARATOR.compare(shapes[j], pivot) < 0) {
                i++; // Increment index of smaller element
                swap(shapes, i, j); // Swap if the current element is smaller than the pivot
            }
        }
        swap(shapes, i + 1, high); // Place the pivot element in the correct position
        return i + 1; // Return the partitioning index
    }
    
    // Gnome Sort
    public void gnomeSort(T[] shapes) {
        int index = 0;
        int n = shapes.length;

        while (index < n) {
            if (index == 0) {
                index++;
            }
            if (shapes[index] != null && shapes[index - 1] != null && 
                COMPARATOR.compare(shapes[index - 1], shapes[index]) > 0) {
                // Swap if the previous element is greater than the current
                swap(shapes, index, index - 1);
                index--; // Move left
            } else {
                index++; // Move right
            }
        }
    }
    

    // Helper method to swap shapes
    private void swap(T[] shapes, int i, int j) {
        T temp = shapes[i];
        shapes[i] = shapes[j];
        shapes[j] = temp;
    }
}