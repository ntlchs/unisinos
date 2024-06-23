public class Main {

  public static void main(String[] args) {
    // Testando LinkedStack
    System.out.println("Testando pilha encadeada...");
    LinkedStack<Character> pilha = new LinkedStack<>(5);
    testaPilha(pilha);

    System.out.println("\n------------------------\n");
    // Testando LinkedQueue
    System.out.println("Testando fila encadeada...");
    LinkedQueue<Character> fila = new LinkedQueue<>(5);
    testaFila(fila);
  }

  public static void testaPilha(LinkedStack<Character> pilha) {
    System.out.println("Pilha vazia: " + pilha.isEmpty());
    System.out.println("Pilha cheia: " + pilha.isFull());
    System.out.println("Tamanho da pilha: " + pilha.size());
    System.out.println("Número de elementos na pilha: " + pilha.numElements());

    System.out.println(
      "Adicionando elementos 'a', 'b', 'c', 'd' e 'e' na pilha... "
    );
    pilha.push('a');
    pilha.push('b');
    pilha.push('c');
    pilha.push('d');
    pilha.push('e');

    System.out.println("Pilha vazia: " + pilha.isEmpty());
    System.out.println("Pilha cheia: " + pilha.isFull());
    System.out.println("Tamanho da pilha: " + pilha.size());
    System.out.println("Número de elementos na pilha: " + pilha.numElements());
    System.out.println("Elemento no topo: " + pilha.top());

    System.out.println("Removendo do topo: " + pilha.pop());
    System.out.println("Removendo do topo: " + pilha.pop());
    System.out.println("Elemento no topo: " + pilha.top());

    System.out.println("Pilha vazia: " + pilha.isEmpty());
    System.out.println("Pilha cheia: " + pilha.isFull());
    System.out.println("Tamanho da pilha: " + pilha.size());
    System.out.println("Número de elementos na pilha: " + pilha.numElements());
  }

  public static void testaFila(LinkedQueue<Character> fila) {
    System.out.println("Fila vazia: " + fila.isEmpty());
    System.out.println("Fila cheia: " + fila.isFull());
    System.out.println("Tamanho da fila: " + fila.size());
    System.out.println("Número de elementos na fila: " + fila.numElements());

    System.out.println(
      "Adicionando elementos 'a', 'b', 'c', 'd' e 'e' na fila... "
    );
    fila.enqueue('a');
    fila.enqueue('b');
    fila.enqueue('c');
    fila.enqueue('d');
    fila.enqueue('e');

    System.out.println("Fila vazia: " + fila.isEmpty());
    System.out.println("Fila cheia: " + fila.isFull());
    System.out.println("Tamanho da fila: " + fila.size());
    System.out.println("Número de elementos na fila: " + fila.numElements());
    System.out.println("Elemento na frente: " + fila.front());
    System.out.println("Elemento atrás: " + fila.back());

    System.out.println("Removendo da frente: " + fila.dequeue());
    System.out.println("Removendo da frente: " + fila.dequeue());
    System.out.println("Elemento na frente: " + fila.front());

    System.out.println("Fila vazia: " + fila.isEmpty());
    System.out.println("Fila cheia: " + fila.isFull());
    System.out.println("Tamanho da fila: " + fila.size());
    System.out.println("Número de elementos na fila: " + fila.numElements());
  }
}
