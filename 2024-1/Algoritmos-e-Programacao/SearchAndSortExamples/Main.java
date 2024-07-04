import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        String nl = System.lineSeparator();

        // Test factorial
        System.out.println("Factorial of 5: " + main.factorial(5));

        System.out.println(nl);

        // Test sequential search
        int[] array = { 1, 3, 5, 7, 9 };
        System.out.println("Sequential search: " + Arrays.toString(array));
        System.out.println("Sequential search for 5: " + main.sequentialSearch(array, 5));
        System.out.println("Sequential search for 2: " + main.sequentialSearch(array, 2));

        System.out.println(nl);

        // Test binary search
        System.out.println("Binary Search: " + Arrays.toString(array));
        System.out.println("Binary search for 5: " + main.binarySearch(array, 5));
        System.out.println("Binary search for 2: " + main.binarySearch(array, 2));

        System.out.println(nl);

        // Test insertion sort
        int[] unsortedArray = { 5, 2, 9, 1, 5, 6 };

        System.out.println("Insertion Sort: " + Arrays.toString(unsortedArray));
        main.insertionSort(unsortedArray);
        System.out.println("Sorted array (Insertion Sort): " + Arrays.toString(unsortedArray));

        System.out.println(nl);

        // Test bubble sort
        unsortedArray = new int[] { 5, 2, 9, 1, 5, 6 };
        System.out.println("Bubble Sort: " + Arrays.toString(unsortedArray));
        main.bubbleSort(unsortedArray);
        System.out.println("Sorted array (Bubble Sort): " + Arrays.toString(unsortedArray));

        System.out.println(nl);

        // Test selection sort
        unsortedArray = new int[] { 5, 2, 9, 1, 5, 6 };
        System.out.println("Selection Sort: " + Arrays.toString(unsortedArray));
        main.selectionSort(unsortedArray);
        System.out.println("Sorted array (Selection Sort): " + Arrays.toString(unsortedArray));

    }

    // Example of recursion
    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            int factorial = factorial(n - 1);
            System.out.println("Factorial of " + (n - 1) + ": " + factorial);
            return n * factorial;
        }
    }

    // Example of sequential search
    public int sequentialSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Checking " + array[i]);
            if (array[i] == key) {
                System.out.println("Found key " + array[i] + " at index " + i);
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
            System.out.println("Checking middle " + array[mid]);
            if (array[mid] == key) {
                System.out.println("Found key " + array[mid]);
                return mid;
            } else if (array[mid] < key) {
                low = mid + 1;
                System.out.println("Adjusting low to " + array[low]);
            } else {
                high = mid - 1;
                System.out.println("Adjusting high to " + array[high]);
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
