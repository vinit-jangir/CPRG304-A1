package src.utilities;

import src.shapes.Shape;
import java.util.Comparator;

// Sorting Class to keep all the sorting methods.
public class Sort<T extends Shape> {

    private final Comparator<T> COMPARATOR; // Comparator for comparing Shape objects

    // Constructor to initialize the COMPARATOR
    public Sort(Comparator<T> comparator) {
        this.COMPARATOR = comparator; // Assign the provided comparator
    }

    /**
     * Bubble Sort with Early Exit Optimization.
     * This sorting algorithm repeatedly steps through the array,
     * compares adjacent elements and swaps them if they are in the wrong order.
     * The pass through the array is repeated until no swaps are needed,
     * which means the array is sorted.
     *
     * @param shapes the array of Shape objects to be sorted
     */
    public void bubbleSort(T[] shapes) {
        int n = shapes.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap if needed
                if (COMPARATOR.compare(shapes[j], shapes[j + 1]) > 0) {
                    swap(shapes, j, j + 1);
                    swapped = true; // Indicate that a swap occurred
                }
            }

            // Exit early if no elements were swapped
            if (!swapped) break;
        }
    }

    /**
     * Selection Sort.
     * This algorithm divides the input list into two parts: the sorted part
     * and the unsorted part. It repeatedly selects the smallest (or largest)
     * element from the unsorted part and moves it to the end of the sorted part.
     *
     * @param shapes the array of Shape objects to be sorted
     */
    public void selectionSort(T[] shapes) {
        int n = shapes.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Index of the smallest element

            // Find the index of the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (COMPARATOR.compare(shapes[j], shapes[minIndex]) < 0) {
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            swap(shapes, i, minIndex);
        }
    }
    
    /**
     * Insertion Sort.
     * This algorithm builds the final sorted array one item at a time.
     * It takes each element from the input data and finds the correct position
     * in the sorted part of the array, shifting elements as necessary.
     *
     * @param shapes the array of Shape objects to be sorted
     */
    public void insertionSort(T[] shapes) {
        int n = shapes.length;

        for (int i = 1; i < n; i++) {
            T key = shapes[i]; // Element to be positioned
            int j;

            // Shift elements of the sorted section that are greater than the key
            for (j = i - 1; j >= 0 && COMPARATOR.compare(shapes[j], key) > 0; j--) {
                shapes[j + 1] = shapes[j]; // Shift element to the right
            }

            // Insert the key at the correct position in the sorted section
            shapes[j + 1] = key;
        }
    }

    /**
     * Merge Sort.
     * This algorithm divides the array into halves, sorts them, and then merges
     * the sorted halves back together. It is a divide-and-conquer algorithm.
     *
     * @param shapes the array of Shape objects to be sorted
     */
    public void mergeSort(T[] shapes) {
        if (shapes.length < 2) return; // Base case: array is already sorted
        int mid = shapes.length / 2;

        // Create left and right sub-arrays
        T[] left = (T[]) new Shape[mid];
        T[] right = (T[]) new Shape[shapes.length - mid];

        // Copy data to temporary arrays
        System.arraycopy(shapes, 0, left, 0, mid);
        System.arraycopy(shapes, mid, right, 0, shapes.length - mid);

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);
        merge(shapes, left, right); // Merge sorted halves
    }

    private void merge(T[] shapes, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        // Merge elements from left and right arrays into shapes array
        for (int n = left.length + right.length; k < n; k++) {
            if (i < left.length && j < right.length) {
                // Choose the smaller element from left or right array
                if (COMPARATOR.compare(left[i], right[j]) <= 0) {
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
    
    /**
     * Quick Sort.
     * This is an efficient, in-place sorting algorithm that uses a divide-and-conquer
     * approach. It picks an element as a pivot and partitions the array around the pivot.
     *
     * @param shapes the array of Shape objects to be sorted
     */
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

        // Partition the array around the pivot
        for (int j = low; j < high; j++) {
            if (COMPARATOR.compare(shapes[j], pivot) < 0) {
                i++; // Increment index of smaller element
                swap(shapes, i, j); // Swap if the current element is smaller than the pivot
            }
        }
        swap(shapes, i + 1, high); // Place the pivot element in the correct position
        return i + 1; // Return the partitioning index
    }
    
    /**
     * Gnome Sort.
     * This sorting algorithm is a variation of insertion sort. It works by
     * iterating through the array and swapping elements that are out of order.
     *
     * @param shapes the array of Shape objects to be sorted
     */
    public void gnomeSort(T[] shapes) {
        int index = 0;
        int n = shapes.length;

        while (index < n) {
            if (index == 0) {
                index++; // Start at the beginning
            }
            if (COMPARATOR.compare(shapes[index - 1], shapes[index]) > 0) {
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
        shapes[j] = temp; // Swap elements at indices i and j
    }
}