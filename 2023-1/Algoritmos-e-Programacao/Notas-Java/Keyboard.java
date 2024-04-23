import java.util.Scanner;

public class Keyboard {

  private static Scanner scanner = new Scanner(System.in);

  public static int readInt() {
    int input = scanner.nextInt();
    scanner.nextLine(); // consume the remaining newline character
    return input;
  }

  public static float readFloat() {
    float input = scanner.nextFloat();
    scanner.nextLine(); // consume the remaining newline character
    return input;
  }

  public static String readString() {
    String input = scanner.nextLine();
    return input;
  }

  public static char readChar() {
    String input = scanner.nextLine();
    return input.charAt(0);
  }
}
