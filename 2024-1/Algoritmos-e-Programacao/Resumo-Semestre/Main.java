import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


interface Movable {
    void move();
}

class Car implements Movable {
    public void move() {
        System.out.println("The car is moving");
    }
}

// Generic class example
class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        // Example of a bidimensional array
        int[][] bidimensionalArray = new int[3][6];
        // Example of looping through a bidimensional array
        for (int i = 0; i < bidimensionalArray.length; i++) {
            for (int j = 0; j < bidimensionalArray[i].length; j++) {
                System.out.print(bidimensionalArray[i][j] + " ");
            }
            System.out.println();
        }

        // Example of abstract class and interface
        Animal animal = new Dog();
        animal.makeSound();

        // Example of interface
        Movable car = new Car();
        car.move();

        // Example of exceptions (try-catch and throws)
        try {
            main.readFile("example.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Example of file reading
        main.readFileWithScanner("example.txt");

        // Example of file writing
        main.writeFile("output.txt");

        // Example of casting
        int intValue = 42;
        double doubleValue = (double) intValue;
        System.out.println("Casting int to double: " + doubleValue);

        // Example of assignment
        int x = 10;
        int y = 20;
        x = y;
        System.out.println("After assignment, x: " + x);

        // Example of recursion
        System.out.println("Factorial of 5: " + main.factorial(5));

        // Example of search methods
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Sequential search for 3: " + main.sequentialSearch(arr, 3));
        System.out.println("Binary search for 3: " + main.binarySearch(arr, 3));

        // Example of sorting methods
        int[] unsortedArray = {5, 2, 9, 1, 5, 6};
        main.insertionSort(unsortedArray);
        main.printArray(unsortedArray, "Insertion Sort");

        int[] unsortedArray2 = {5, 2, 9, 1, 5, 6};
        main.bubbleSort(unsortedArray2);
        main.printArray(unsortedArray2, "Bubble Sort");

        int[] unsortedArray3 = {5, 2, 9, 1, 5, 6};
        main.selectionSort(unsortedArray3);
        main.printArray(unsortedArray3, "Selection Sort");

        // Example of generic types
        Box<Integer> integerBox = new Box<>();
        integerBox.set(10);
        System.out.println("Box contains: " + integerBox.get());
    }

    // Example of reading a file
    public void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // Example of reading a file with Scanner
    public void readFileWithScanner(String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Example of writing to a file
    public void writeFile(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            writer.println("Hello, world!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Example of binary search
    public int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
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
        }
    }

    // Helper method to print arrays
    public void printArray(int[] array, String sortType) {
        System.out.print(sortType + ": ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
