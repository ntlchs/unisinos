import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    // Exemplos de expressões para testar
    Metodo1<Integer> metodo1 = new Metodo1<>(10);

    int[] numbers = new int[] { 1, 2, 3, 1, 5, 1, 7, 8, 9, 10 };

    for (int number : numbers) {
      metodo1.addToList(number);
    }

    int count = metodo1.contaElementos(1);

    System.out.println("O número 1 aparece " + count + " vezes");

    Metodo2 metodo2 = new Metodo2();

    String[] expressions = {
      "((1 + 2) * 3)",
      "((1 + 2) * 3",
      "((1 + 2) * 3))",
      "((1 + 2) * 3))(",
      "((1 + 2) * 3))()",
      "((1 + 2) * 3)()",
      "((1 + 2) * 3)(",
      "((1 + 2) * 3))",
      "((1 + 2) * 3))(",
    };

    // Testar cada expressão
    for (String expr : expressions) {
      Stack<Character> expressionStack = new Stack<>();
      // Adiciona os caracteres na pilha na ordem inversa
      for (int i = expr.length() - 1; i >= 0; i--) {
        expressionStack.push(expr.charAt(i));
      }

      // Verificar a validade dos parênteses na expressão
      boolean isValid = metodo2.checkBrackets(expressionStack);
      String valid = "";
      if (!isValid) {
        valid = "não";
      }

      System.out.println(
        "Expressão " +
        expr +
        " " +
        valid +
        " tem parênteses corretamente agrupados"
      );
    }
  }
}
