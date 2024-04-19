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
    testOverflowException();
    testUnderflowException();
  }

  private static void testIntegerList() {
    Metodo1<Integer> metodo1 = new Metodo1<>(10);
    Integer[] numbers = { 1, 2, 3, 1, 5, 1, 7, 10, 9, 0 };
    metodo1.initList(numbers);
    int count = metodo1.contaElementos(1);
    System.out.println("number 1: " + count);
  }

  private static void testStringList() {
    Metodo1<String> metodo1String = new Metodo1<>(10);
    String[] strings = { "a", "b", "c", "a", "e", "a", "b", "c", "d", "e" };
    metodo1String.initList(strings);
    int countString = metodo1String.contaElementos("a");
    System.out.println("string 'a': " + countString);
  }

  private static void testDoubleList() {
    Metodo1<Double> metodo1Double = new Metodo1<>(10);
    Double[] doubles = { 1.0, 2.0, 3.0, 1.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
    metodo1Double.initList(doubles);
    int countDouble = metodo1Double.contaElementos(1.0);
    System.out.println("number 1.0: " + countDouble);
  }

  private static void testCharacterList() {
    Metodo1<Character> metodo1Char = new Metodo1<>(10);
    Character[] chars = { 'a', 'b', 'c', 'a', 'e', 'a', 'b', 'c', 'd', 'e' };
    metodo1Char.initList(chars);
    int countChar = metodo1Char.contaElementos('a');
    System.out.println("char 'a': " + countChar);
  }

  private static void testBooleanList() {
    Metodo1<Boolean> metodo1Boolean = new Metodo1<>(10);
    Boolean[] booleans = {
      true,
      false,
      true,
      true,
      false,
      false,
      false,
      false,
      false,
      false,
    };
    metodo1Boolean.initList(booleans);
    int countBoolean = metodo1Boolean.contaElementos(true);
    System.out.println("true: " + countBoolean);
  }

  private static void testArrayList() {
    Metodo1<int[]> metodo1Array = new Metodo1<>(10);
    int[] arr1 = { 1, 2, 3 };
    int[] arr2 = { 1, 2, 4 };
    int[][] arrays = {
      arr1,
      arr1,
      arr2,
      arr1,
      arr2,
      arr2,
      arr2,
      arr2,
      arr2,
      arr2,
    };
    metodo1Array.initList(arrays);
    int countArr = metodo1Array.contaElementos(arr1);
    System.out.println("array [1, 2, 3]: " + countArr);
  }

  private static void testNoObject() {
    Metodo1<Object> metodo1Object = new Metodo1<>(3);
    Object[] objects = { new Object(), new Object(), new Object() };
    metodo1Object.initList(objects);
    int countObject = 0;
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
      Stack<Character> expressionStack = new StaticStack<>(expr.length());
      for (int i = 0; i < expr.length(); i++) {
        expressionStack.push(expr.charAt(i));
      }

      String isValid =
        (metodo2.checkBrackets(expressionStack) ? "valid" : "invalid");

      System.out.println(expr + ": " + isValid + " ()");
    }
  }

  private static void testOverflowException() {
    StaticQueue<Integer> queue = new StaticQueue<>(3);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
  }

  public static void testUnderflowException() {
    StaticQueue<Integer> queue = new StaticQueue<>(3);
    queue.dequeue();
  }
}
