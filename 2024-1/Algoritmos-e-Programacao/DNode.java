public class DNode<E> {

  private E element;
  private DNode<E> next;
  private DNode<E> previous;

  public DNode(E element) {
    this(element, null, null);
  }

  public E getElement() {}

  public void setElement(E element) {}

  public DNode<E> getNext() {}

  public void setNext(DNode<E> next) {}

  public DNode<E> getPrevious() {}

  public void setPrevious(DNode<E> previous) {}
}
