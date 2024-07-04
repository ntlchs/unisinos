import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
        String nl = System.lineSeparator();

        System.out.println("=== bidimensional array ===");
        int[][] bidimensionalArray = new int[3][6];
        int count = 0;
        for (int i = 0; i < bidimensionalArray.length; i++) {
            for (int j = 0; j < bidimensionalArray[i].length; j++) {
                bidimensionalArray[i][j] = count;
                count++;
            }
        }
        for (int i = 0; i < bidimensionalArray.length; i++) {
            for (int j = 0; j < bidimensionalArray[i].length; j++) {
                System.out.print(bidimensionalArray[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(nl);

        System.out.println("=== inheritance ===");
        System.out.println("animal is a dog");
        System.out.println("animal make sound: ");
        Animal animal = new Dog();
        animal.makeSound();

        System.out.println(nl);

        System.out.println("=== interface ===");
        Movable car = new Car();
        car.move();

        System.out.println(nl);

        System.out.println("=== exception ===");
        try {
            main.readFile("foo.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(nl);

        System.out.println("=== File Reading ===");
        try {
            main.readFile("example.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(nl);

        System.out.println("=== File Writing ===");
        try {
            main.writeFile("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("output.txt created");

        System.out.println(nl);

        System.out.println("=== casting ===");
        int intValue = 42;
        double doubleValue = (double) intValue;
        System.out.println("Casting int to double: " + doubleValue);

        System.out.println(nl);

        System.out.println("=== assignment ===");
        double x = 10;
        int y = 20;
        x = y;
        System.out.println("assigned int y to double x: " + x);

        System.out.println(nl);

        System.out.println("=== recursion ===");
        System.out.println("factorial of 5: " + main.factorial(5));

        System.out.println(nl);

        System.out.println("=== search ===");
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("sequential search for 3: " + main.sequentialSearch(arr, 3));
        System.out.println("binary search for 3: " + main.binarySearch(arr, 3));

        System.out.println(nl);

        System.out.println("=== insertion sort ===");
        int[] unsortedArray = { 5, 2, 9, 1, 5, 6 };
        System.out.println(Arrays.toString(unsortedArray));
        main.insertionSort(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));

        System.out.println(nl);

        System.out.println("=== bubble sort ===");
        int[] unsortedArray2 = { 5, 2, 9, 1, 5, 6 };
        System.out.println(Arrays.toString(unsortedArray2));

        main.bubbleSort(unsortedArray2);
        System.out.println(Arrays.toString(unsortedArray2));

        System.out.println(nl);

        System.out.println("=== selection sort ===");
        int[] unsortedArray3 = { 5, 2, 9, 1, 5, 6 };
        System.out.println(Arrays.toString(unsortedArray3));
        main.selectionSort(unsortedArray3);
        System.out.println(Arrays.toString(unsortedArray3));

        System.out.println(nl);

        System.out.println("=== generic types ===");
        Box<Integer> integerBox = new Box<>();
        integerBox.set(10);
        System.out.println("box contains: " + integerBox.get());

        System.out.println(nl);

        System.out.println("=== StaticList ===");
        StaticList<Integer> staticList = new StaticList<>(10);
        staticList.insert(0, 0);
        staticList.insert(1, 1);
        staticList.insert(2, 2);
        staticList.insert(3, 3);
        System.out.println("StaticList: " + staticList.toString());
        staticList.remove(3);
        System.out.println("after remove at pos 3: " + staticList.toString());
        System.out.println("is empty:" + staticList.isEmpty() + ", is full: " + staticList.isFull());

        System.out.println(nl);

        System.out.println("=== SinglyLinkedList ===");
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insertFirst(0);
        singlyLinkedList.insertLast(1);
        singlyLinkedList.insertFirst(2);
        singlyLinkedList.insert(4, 1);
        System.out.println("SinglyLinkedList: " + singlyLinkedList);
        int sllPos = singlyLinkedList.search(4);
        System.out.println("search for 4, position: " + sllPos);
        singlyLinkedList.remove(1);
        System.out.println("after remove at pos 1: " + singlyLinkedList);
        System.out.println("is empty:" + singlyLinkedList.isEmpty() + ", is full: " + singlyLinkedList.isFull());

        System.out.println(nl);

        System.out.println("=== DoublyLinkedList ===");
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insert(3, 0);
        doublyLinkedList.insert(2, 1);
        doublyLinkedList.insertFirst(4);
        doublyLinkedList.insertLast(5);
        System.out.println("DoublyLinkedList: " + doublyLinkedList);
        doublyLinkedList.remove(1);
        System.out.println("is empty:" + doublyLinkedList.isEmpty() + ", is full: " + doublyLinkedList.isFull());
        System.out.println("DoublyLinkedList: " + doublyLinkedList);

        System.out.println(nl);

        System.out.println("=== StaticStack ===");
        StaticStack<Integer> staticStack = new StaticStack<>(10);
        staticStack.push(1);
        staticStack.push(2);
        staticStack.push(3);
        staticStack.push(4);
        System.out.println("StaticStack: " + staticStack.toString());
        System.out.println("Top: " + staticStack.top());
        staticStack.pop();
        System.out.println("StaticStack after pop: " + staticStack.toString());
        System.out.println("is empty:" + staticStack.isEmpty() + ", is full: " + staticStack.isFull());

        System.out.println(nl);

        System.out.println("=== StaticQueue ===");
        StaticQueue<Integer> staticQueue = new StaticQueue<>(10);
        staticQueue.enqueue(1);
        staticQueue.enqueue(2);
        staticQueue.enqueue(3);
        staticQueue.enqueue(4);
        System.out.println("StaticQueue: " + staticQueue.toString());
        System.out.println("Front: " + staticQueue.front());
        System.out.println("Back: " + staticQueue.back());
        staticQueue.dequeue();
        System.out.println("StaticQueue after dequeue: " + staticQueue.toString());
        System.out.println("is empty:" + staticQueue.isEmpty() + ", is full: " + staticQueue.isFull());

        System.out.println(nl);
        System.out.println("=== End :) ===");
    }

    public void readFile(String fileName) throws FileNotFoundException, IOException {
        if (fileName == null) {
            throw new IllegalArgumentException("File name is null");
        }
        FileReader fr = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fr);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

    }

    public void readFileWithScanner(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    public void writeFile(String fileName) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        writer.println("Hello, world!");
        writer.close();
    }

    // recursion
    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public int sequentialSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

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

    public void insertionSort(int[] arr) {
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

    public void bubbleSort(int[] arr) {
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

    public void selectionSort(int[] arr) {
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
