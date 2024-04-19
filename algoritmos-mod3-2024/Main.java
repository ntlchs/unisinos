import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    testIntegerList();
    testStringList();
    testDoubleList();
    testCharacterList();
    testBooleanList();
    testArrayList();
    testNoObject();
    testBracketChecking();
  }

  private static void testIntegerList() {
    Metodo1<Integer> metodo1 = new Metodo1<>();
    Integer[] numbers = { 1, 2, 3, 1, 5, 1, 7, 8, 9, 10 };
    metodo1.initList(numbers);
    int count = metodo1.contaElementos(1);
    System.out.println("number 1: " + count);
  }

  private static void testStringList() {
    Metodo1<String> metodo1String = new Metodo1<>();
    String[] strings = { "a", "b", "c", "a", "e", "a" };
    metodo1String.initList(strings);
    int countString = metodo1String.contaElementos("a");
    System.out.println("string 'a': " + countString);
  }

  private static void testDoubleList() {
    Metodo1<Double> metodo1Double = new Metodo1<>();
    Double[] doubles = { 1.0, 2.0, 3.0, 1.0, 1.0 };
    metodo1Double.initList(doubles);
    int countDouble = metodo1Double.contaElementos(1.0);
    System.out.println("number 1.0: " + countDouble);
  }

  private static void testCharacterList() {
    Metodo1<Character> metodo1Char = new Metodo1<>();
    Character[] chars = { 'a', 'b', 'c', 'a', 'e', 'a' };
    metodo1Char.initList(chars);
    int countChar = metodo1Char.contaElementos('a');
    System.out.println("char 'a': " + countChar);
  }

  private static void testBooleanList() {
    Metodo1<Boolean> metodo1Boolean = new Metodo1<>();
    Boolean[] booleans = { true, false, true, true, false };
    metodo1Boolean.initList(booleans);
    int countBoolean = metodo1Boolean.contaElementos(true);
    System.out.println("true: " + countBoolean);
  }

  private static void testArrayList() {
    Metodo1<int[]> metodo1Array = new Metodo1<>();
    int[] arr1 = { 1, 2, 3 };
    int[] arr2 = { 1, 2, 4 };
    int[][] arrays = { arr1, arr1, arr2, arr1 };
    metodo1Array.initList(arrays);
    int countArr = metodo1Array.contaElementos(arr1);
    System.out.println("array [1, 2, 3]: " + countArr);
  }

  private static void testNoObject() {
    Metodo1<Object> metodo1Object = new Metodo1<>();
    Object[] objects = { new Object(), new Object(), new Object() };
    metodo1Object.initList(objects);
    int countObject = metodo1Object.contaElementos(new Object());
    System.out.println("object: " + countObject);
  }

  private static void testBracketChecking() {
    Metodo2 metodo2 = new Metodo2();

    String[] expressions = {
      "((1 + 2) * 3)", // valid
      "((1 + 2) * 3))", // invalid
      "(((1 + 2) * 3)", // invalid
    };

    for (String expr : expressions) {
      Stack<Character> expressionStack = new Stack<>();
      for (int i = 0; i < expr.length(); i++) {
        expressionStack.add(expr.charAt(i));
      }

      String isValid =
        (metodo2.checkBrackets(expressionStack) ? "valid" : "invalid");

      System.out.println(expr + ": " + isValid + " ()");
    }
  }
}
