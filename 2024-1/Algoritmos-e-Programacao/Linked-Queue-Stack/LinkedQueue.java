public class LinkedQueue<E> implements Queue<E> {

  private Node<E> front;
  private Node<E> back;
  private int numElements;
  private int size;

  public LinkedQueue(int size) {
    front = null;
    back = null;
    numElements = 0;
    this.size = size;
  }

  public int numElements() {
    return numElements;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return numElements == 0;
  }

  public boolean isFull() {
    return numElements >= size;
  }

  public E back() throws UnderflowException {
    if (isEmpty()) {
      throw new UnderflowException();
    }

    return back.getElement();
  }

  public void enqueue(E element)
    throws OverflowException, NullArgumentException {
    if (isFull()) {
      throw new OverflowException();
    }

    if (element == null) {
      throw new NullArgumentException();
    }

    Node<E> newNode = new Node<>(element);
    if (isEmpty()) {
      front = newNode;
    } else {
      back.setNext(newNode);
    }
    back = newNode;
    numElements++;
  }

  public E dequeue() throws UnderflowException {
    if (isEmpty()) {
      throw new UnderflowException();
    }

    E element = front.getElement();
    front = front.getNext();
    numElements--;

    if (isEmpty()) {
      back = null;
    }

    return element;
  }

  public E front() throws UnderflowException {
    if (isEmpty()) {
      throw new UnderflowException();
    }

    return front.getElement();
  }
}
