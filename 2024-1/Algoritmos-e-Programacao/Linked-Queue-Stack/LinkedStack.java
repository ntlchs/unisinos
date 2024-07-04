public class LinkedStack<E> implements Stack<E> {

  private Node<E> top;
  private int numElements;
  private int size;

  public LinkedStack(int size) {
    top = null;
    numElements = 0;
    this.size = size;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return numElements == 0;
  }

  public int numElements() {
    return numElements;
  }

  public boolean isFull() {
    return numElements == size;
  }

  public void push(E element) throws OverflowException, NullArgumentException {
    if (isFull()) {
      throw new OverflowException();
    }
    if (element == null) {
      throw new NullArgumentException();
    }
    Node<E> newNode = new Node<>(element);
    newNode.setNext(top);
    top = newNode;
    numElements++;
  }

  public E pop() throws UnderflowException {
    if (isEmpty()) {
      throw new UnderflowException();
    }
    E element = top.getElement();
    top = top.getNext();
    numElements--;
    return element;
  }

  public E top() throws UnderflowException {
    if (isEmpty()) {
      throw new UnderflowException();
    }

    return top.getElement();
  }

  public void clear() {
    top = null;
    size = 0;
  }
}
