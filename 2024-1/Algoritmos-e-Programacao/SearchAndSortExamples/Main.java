import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        String nl = System.lineSeparator();

        System.out.println("recursion: factorial of 5 is " + main.factorial(5));

        System.out.println(nl);

        int[] array = { 1, 3, 5, 7, 9 };
        System.out.println("sequential search: array = " + Arrays.toString(array));
        System.out.println("search for 5: " + main.sequentialSearch(array, 5));
        System.out.println("search for 2: " + main.sequentialSearch(array, 2));

        System.out.println(nl);

        System.out.println("binary search: " + Arrays.toString(array));
        System.out.println("search for 5: " + main.binarySearch(array, 5));
        System.out.println("search for 2: " + main.binarySearch(array, 2));

        System.out.println(nl);

        int[] unsortedArray = { 5, 2, 9, 1, 5, 6 };

        System.out.println("insertion Sort: " + Arrays.toString(unsortedArray));
        main.insertionSort(unsortedArray);
        System.out.println("result: " + Arrays.toString(unsortedArray));

        System.out.println(nl);

        unsortedArray = new int[] { 5, 2, 9, 1, 5, 6 };

        System.out.println("bubble sort: " + Arrays.toString(unsortedArray));
        main.bubbleSort(unsortedArray);
        System.out.println("result: " + Arrays.toString(unsortedArray));

        System.out.println(nl);

        unsortedArray = new int[] { 5, 2, 9, 1, 5, 6 };

        System.out.println("selection sort: " + Arrays.toString(unsortedArray));
        main.selectionSort(unsortedArray);
        System.out.println("result: " + Arrays.toString(unsortedArray));

    }

    // recursion
    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // sequential search
    public int sequentialSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("checking " + array[i]);
            if (array[i] == key) {
                System.out.println("found key " + array[i] + " at index " + i);
                return i;
            }
        }
        System.out.println("key not found");
        return -1;
    }

    // binary search
    public int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("checking mid: " + array[mid]);
            if (array[mid] == key) {
                System.out.println("found key " + array[mid] + "at index " + mid);
                return mid;
            } else if (array[mid] < key) {
                low = mid + 1;
                System.out.println("key > arr[mid], adjusting low to " + array[low]);
            } else { // array[mid] > key
                high = mid - 1;
                System.out.println("key < arr[mid], adjusting high to " + array[high]);
            }
        }
        System.out.println("key not found");
        return -1;
    }

    // insertion sort
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            System.out.println("added key " + key + ": " + Arrays.toString(array));
        }
    }

    public void insercaoDireta(int[] arr) { // versao do prof
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            int B = arr[i];
            while ((j > 0 && arr[j - 1] > B)) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = B;
        }
    }

    // bubble sort
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
                        "after comparing " + array[j] + " and " + array[j + 1] + ": " + Arrays.toString(array));
            }
        }
    }

    public void bubbleSort2(int[] arr) { // versão do prof
        int i = arr.length - 1;
        while (i > 0) {
            int lastFlipped = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int T = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = T;
                    lastFlipped = j;
                }
            }
            i = lastFlipped;
        }
    }

    // sort
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
                    "after swapping " + array[i] + " and " + array[minIndex] + ": " + Arrays.toString(array));
        }
    }

    public void selectionSort2(int[] arr) { // versão do prof
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }

            }
            int T = arr[i];
            arr[i] = arr[min];
            arr[min] = T;
        }
    }
}
