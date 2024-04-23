package Tamagotchi;

import java.util.Scanner;

public class Teclado {

    private static Scanner scanner = new Scanner(System.in);

    public static int leInt() {
        return scanner.nextInt();
    }

    public static String leString() {
        return scanner.nextLine();
    }
}