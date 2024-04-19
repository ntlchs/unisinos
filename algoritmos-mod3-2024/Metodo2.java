import java.util.Stack;

public class Metodo2 {

  public boolean checkBrackets(Stack<Character> stack) {
    int balance = 0;
    while (!stack.isEmpty()) {
      char c = stack.pop();
      if (c == ')') {
        balance++;
      } else if (c == '(') {
        balance--;
        if (balance < 0) { // if there is a ')' without a '(' before it, <0 because the stack starts from the end
          return false;
        }
      }
    }
    return balance == 0; // will be true if there are the same number of '(' and ')'
  }
}
