package src.utilities;

import src.shapes.Shape;
import java.util.Comparator;

// Sorting Class to keep all the sorting methods.
public class Sort<T extends Shape> {

    private Comparator<T> comparator;

    // Constructor to initialize the comparator
    public Sort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    // Bubble Sort
    public void bubbleSort(T[] shapes) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shapes[j] != null && shapes[j + 1] != null &&
                    comparator.compare(shapes[j], shapes[j + 1]) > 0) {
                    swap(shapes, j, j + 1);
                }
            }
        }
    }

    // Selection Sort
    public void selectionSort(T[] shapes) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (shapes[j] != null && shapes[minIndex] != null &&
                    comparator.compare(shapes[j], shapes[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(shapes, i, minIndex);
        }
    }

    // Insertion Sort
    public void insertionSort(T[] shapes) {
        int n = shapes.length;
        for (int i = 1; i < n; i++) {
            T key = shapes[i];
            if (key != null) {
                int j = i - 1;
                while (j >= 0 && shapes[j] != null && comparator.compare(shapes[j], key) > 0) {
                    shapes[j + 1] = shapes[j];
                    j--;
                }
                shapes[j + 1] = key;
            }
        }
    }

    // Merge Sort
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

        while (i < left.length && j < right.length) {
            if (left[i] != null && right[j] != null &&
                comparator.compare(left[i], right[j]) <= 0) {
                shapes[k++] = left[i++];
            } else if (right[j] != null) {
                shapes[k++] = right[j++];
            } else {
                i++;
            }
        }

        while (i < left.length) {
            shapes[k++] = left[i++];
        }

        while (j < right.length) {
            shapes[k++] = right[j++];
        }
    }

    // Quick Sort
    public void quickSort(T[] shapes) {
        quickSort(shapes, 0, shapes.length - 1);
    }

    private void quickSort(T[] shapes, int low, int high) {
        if (low < high) {
            int pi = partition(shapes, low, high);
            quickSort(shapes, low, pi - 1);
            quickSort(shapes, pi + 1, high);
        }
    }

    private int partition(T[] shapes, int low, int high) {
        T pivot = shapes[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (shapes[j] != null && pivot != null &&
                comparator.compare(shapes[j], pivot) < 0) {
                i++;
                swap(shapes, i, j);
            }
        }
        swap(shapes, i + 1, high);
        return i + 1;
    }

    // Helper method to swap shapes
    private void swap(T[] shapes, int i, int j) {
        T temp = shapes[i];
        shapes[i] = shapes[j];
        shapes[j] = temp;
    }
}