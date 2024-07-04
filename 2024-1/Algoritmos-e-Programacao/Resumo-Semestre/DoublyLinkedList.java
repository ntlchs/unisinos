public class DoublyLinkedList<E> implements List<E> {
	private DNode<E> head;
	private DNode<E> tail;
	private int numElements;

	public DoublyLinkedList() {
		numElements = 0;
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public boolean isFull() {
		return false;
	}

	public int numElements() {
		return numElements;
	}

	public E get(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();
		DNode<E> current = head;
		for (int i = 0; i < pos; i++)
			current = current.getNext();
		return current.getElement();
	}

	public void insertFirst(E element) throws NullPointerException {
		if (element == null)
			throw new NullPointerException();
		DNode<E> n = new DNode<E>(element);
		if (isEmpty()) {
			head = tail = n;
		} else {
			head.setPrevious(n);
			n.setNext(head);
			head = n;
		}
		numElements++;
	}

	public void insertLast(E element) throws NullPointerException {
		if (element == null)
			throw new NullPointerException();
		DNode<E> n = new DNode<E>(element);
		if (isEmpty()) {
			head = tail = n;
		} else {
			tail.setNext(n);
			n.setPrevious(tail);
			tail = n;
		}
		numElements++;
	}

	public void insert(E element, int pos) throws IndexOutOfBoundsException, NullPointerException {
		if (element == null)
			throw new NullPointerException();
		if (pos < 0 || pos > numElements)
			throw new IndexOutOfBoundsException();
		if (pos == 0)
			insertFirst(element);
		else if (pos == numElements)
			insertLast(element);
		else {
			DNode<E> prev = head;
			for (int i = 0; i < pos - 1; i++)
				prev = prev.getNext();
			DNode<E> newNode = new DNode<E>(element);
			newNode.setPrevious(prev);
			newNode.setNext(prev.getNext());
			prev.getNext().setPrevious(newNode);
			prev.setNext(newNode);
			numElements++;
		}
	}

	public E removeFirst() throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		E removedItem = head.getElement();
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.getNext();
			head.setPrevious(null);
		}
		numElements--;
		return removedItem;
	}

	public E removeLast() throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		E removedItem = tail.getElement();
		if (head == tail) {
			head = tail = null;
		} else {
			tail = tail.getPrevious();
			tail.setNext(null);
		}
		numElements--;
		return removedItem;
	}

	public String toString() {
		String s = "";

		DNode<E> current = head;
		while (current != null) {
			s += current.getElement().toString() + " - ";
			current = current.getNext();
		}
		return s;
	}

	public int search(E element) throws NullPointerException {
		if (element == null)
			throw new NullPointerException();

		DNode<E> current = head;
		int i = 0;
		while (current != null) {
			if (element.equals(current.getElement()))
				return i;
			i++;
			current = current.getNext();
		}

		return -1;

	}

	public E remove(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();

		if (pos == 0)
			return removeFirst();
		else if (pos == numElements - 1)
			return removeLast();
		else {
			DNode<E> prev = head;

			for (int i = 0; i < pos - 1; i++)
				prev = prev.getNext();

			E element = prev.getNext().getElement();

			prev.setNext(prev.getNext().getNext());
			prev.getNext().setPrevious(prev);

			numElements--;
			return element;
		}
	}
}
