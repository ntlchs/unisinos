public class Main {

  public static void main(String[] args) {
    testElementCount(new Integer[] { 1, 2, 3, 1, 5, 1 }, 1);
    testElementCount(new String[] { "a", "b", "c", "a", "e", "a" }, "a");
    testElementCount(new Double[] { 1.0, 2.0, 3.0, 1.0, 1.0 }, 1.0);
    testElementCount(new Character[] { 'a', 'b', 'c', 'a', 'e', 'a' }, 'a');
    testElementCount(new Boolean[] { true, false, true, true, false }, true);

    testArrayCount();
    testObjectCount();

    testBracketChecking();
  }

  private static <T> void testElementCount(T[] elements, T target) {
    Metodo1<T> metodo1 = new Metodo1<>(elements.length);
    metodo1.initList(elements);
    int count = metodo1.contaElementos(target);
    System.out.println(target + ": " + count);
  }

  private static void testArrayCount() {
    Metodo1<int[]> metodo1Array = new Metodo1<>(5);
    int[] arr1 = { 1, 2, 3 };
    int[] arr2 = { 1, 2, 4 };
    int[][] arrays = { arr1, arr1, arr2, arr1, arr2 };
    metodo1Array.initList(arrays);
    int countArr = metodo1Array.contaElementos(arr1);
    System.out.println("array [1, 2, 3]: " + countArr);
  }

  private static void testObjectCount() {
    Metodo1<Object> metodo1Obj = new Metodo1<>(5);
    Object obj1 = new Object();
    Object obj2 = new Object();
    Object[] objs = { obj1, obj2, obj1, obj1, obj2 };
    metodo1Obj.initList(objs);
    int countObj = metodo1Obj.contaElementos(obj1);
    System.out.println("object obj(1): " + countObj);
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

      boolean isValid = metodo2.checkBrackets(expressionStack);

      System.out.println(expr + ": " + (isValid ? "valid" : "invalid") + " ()");
    }
  }
}
