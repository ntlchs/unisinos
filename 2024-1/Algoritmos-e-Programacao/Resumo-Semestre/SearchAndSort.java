import java.util.Arrays;

public class SearchAndSort {

    // Example of recursion
    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Example of sequential search
    public int sequentialSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Checking index " + i);
            if (array[i] == key) {
                System.out.println("Found key at index " + i);
                return i;
            }
        }
        System.out.println("Key not found");
        return -1;
    }

    // Example of binary search
    public int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("Checking middle index " + mid);
            if (array[mid] == key) {
                System.out.println("Found key at index " + mid);
                return mid;
            } else if (array[mid] < key) {
                low = mid + 1;
                System.out.println("Adjusting low to " + low);
            } else {
                high = mid - 1;
                System.out.println("Adjusting high to " + high);
            }
        }
        System.out.println("Key not found");
        return -1;
    }

    // Example of insertion sort
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            System.out.println("Inserting " + key + " into sorted part");
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
            System.out.println("Array after inserting " + key + ": " + Arrays.toString(array));
        }
    }

    // Example of bubble sort
    public void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                System.out.println(
                        "Array after comparing " + array[j] + " and " + array[j + 1] + ": " + Arrays.toString(array));
            }
        }
    }

    // Example of selection sort
    public void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            System.out.println(
                    "Array after swapping " + array[i] + " and " + array[minIndex] + ": " + Arrays.toString(array));
        }
    }

}
