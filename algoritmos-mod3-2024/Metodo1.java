public class Metodo1<E> {

  private List<E> list;
  private int size;

  public Metodo1(int size) {
    this.size = size;
    this.list = new StaticList<>(size);
  }

  public void initList(E[] elements) {
    for (int i = 0; i < size; i++) {
      list.insert(elements[i], i);
    }
  }

  public int contaElementos(E element) {
    return recursiveCount(element, 0);
  }

  private int recursiveCount(E element, int index) {
    if (index == size) {
      return 0;
    }
    return (
      (list.get(index).equals(element) ? 1 : 0) +
      recursiveCount(element, index + 1)
    );
  }
}
