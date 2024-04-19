public class Metodo2 {

  public boolean checkBrackets(Stack<Character> s1) {
    int balance = 0;
    while (!s1.isEmpty()) {
      char c = s1.pop();
      if (c == ')') {
        balance++;
      } else if (c == '(') {
        balance--;
        if (balance < 0) {
          return false;
        }
      }
    }
    return balance == 0;
  }
}
