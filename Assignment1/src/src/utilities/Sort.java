package src.utilities;

import src.shapes.Shape;

//Sorting Class to keep all the sorting methods.
//Note: All the sorting method code is being referenced from Hani Mohamed Class notes and instructed youtube videos.

public class Sort {

    // Bubble Sort
    public static void bubbleSort(Shape[] shapes) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shapes[j].compareTo(shapes[j + 1]) > 0) {
                    swap(shapes, j, j + 1);
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(Shape[] shapes) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (shapes[j].compareTo(shapes[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(shapes, i, minIndex);
        }
    }

    // Insertion Sort
    public static void insertionSort(Shape[] shapes) {
        int n = shapes.length;
        for (int i = 1; i < n; i++) {
            Shape key = shapes[i];
            int j = i - 1;
            while (j >= 0 && shapes[j].compareTo(key) > 0) {
                shapes[j + 1] = shapes[j];
                j--;
            }
            shapes[j + 1] = key;
        }
    }

    // Merge Sort
    public static void mergeSort(Shape[] shapes) {
        if (shapes.length < 2) return;
        int mid = shapes.length / 2;

        Shape[] left = new Shape[mid];
        Shape[] right = new Shape[shapes.length - mid];

        System.arraycopy(shapes, 0, left, 0, mid);
        System.arraycopy(shapes, mid, right, 0, shapes.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(shapes, left, right);
    }

    private static void merge(Shape[] shapes, Shape[] left, Shape[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                shapes[k++] = left[i++];
            } else {
                shapes[k++] = right[j++];
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
    public static void quickSort(Shape[] shapes) {
        quickSort(shapes, 0, shapes.length - 1);
    }

    private static void quickSort(Shape[] shapes, int low, int high) {
        if (low < high) {
            int pi = partition(shapes, low, high);
            quickSort(shapes, low, pi - 1);
            quickSort(shapes, pi + 1, high);
        }
    }

    private static int partition(Shape[] shapes, int low, int high) {
        Shape pivot = shapes[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (shapes[j].compareTo(pivot) < 0) {
                i++;
                swap(shapes, i, j);
            }
        }
        swap(shapes, i + 1, high);
        return i + 1;
    }

    // Helper method to swap shapes
    private static void swap(Shape[] shapes, int i, int j) {
        Shape temp = shapes[i];
        shapes[i] = shapes[j];
        shapes[j] = temp;
    }
}
