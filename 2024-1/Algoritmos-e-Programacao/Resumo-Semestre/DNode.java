public class DNode<E> {

    private E element;
    private DNode<E> next;
    private DNode<E> previous;

    public DNode(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DNode<E> getNext() {
        return next;
    }

    public void setNext(DNode<E> next) {
        this.next = next;
    }

    public DNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(DNode<E> previous) {
        this.previous = previous;
    }
}
