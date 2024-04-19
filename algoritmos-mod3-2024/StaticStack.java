/**
 * Implementa��o de uma Pilha com armazenamento est�tico,
 * baseado em array.
 */
public class StaticStack<E> implements Stack<E> {

  // �ndice do elemento no topo da pilha
  protected int top;

  // Array que armazena as refer�ncias para os elementos
  protected E elements[];

  /**
   * Constr�i uma pilha com um tamanho m�ximo.
   * @param maxSize O tamanho m�ximo da pilha
   */

  @SuppressWarnings("unchecked")
  public StaticStack(int maxSize) {
    elements = (E[]) new Object[maxSize];
    top = -1;
  }

  /* (non-Javadoc)
   * @see br.unisinos.prog2lab2.Stack#isEmpty()
   */
  public boolean isEmpty() {
    return top == -1;
  }

  /* (non-Javadoc)
   * @see br.unisinos.prog2lab2.Stack#isFull()
   */
  public boolean isFull() {
    return top == elements.length - 1;
  }

  /* (non-Javadoc)
   * @see br.unisinos.prog2lab2.Stack#numElements()
   */
  public int numElements() {
    return top + 1;
  }

  /* (non-Javadoc)
   * @see br.unisinos.prog2lab2.Stack#push(java.lang.Object)
   */
  public void push(E element) throws OverflowException {
    if (isFull()) throw new OverflowException();
    elements[++top] = element;
  }

  /* (non-Javadoc)
   * @see br.unisinos.prog2lab2.Stack#pop()
   */
  public E pop() throws UnderflowException {
    if (isEmpty()) throw new UnderflowException();
    E element = elements[top];
    elements[top--] = null; // p/ coleta de lixo
    return element;
  }

  /* (non-Javadoc)
   * @see br.unisinos.prog2lab2.Stack#top()
   */
  public E top() throws UnderflowException {
    if (isEmpty()) throw new UnderflowException();
    return elements[top];
  }

  /**
   * Retorna uma representa��o String da pilha.
   * @see java.lang.Object#toString()
   */
  public String toString() {
    if (isEmpty()) return "[Empty]"; else {
      String s = "[";
      for (int i = numElements() - 1; i >= 0; i--) {
        s += "\n" + elements[i];
      }
      s += "\n]";
      return s;
    }
  }
}
