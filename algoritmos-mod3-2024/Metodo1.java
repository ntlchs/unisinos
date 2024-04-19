import java.util.ArrayList;
import java.util.List;

public class Metodo1<E> {

  private List<E> elements = new ArrayList<>();

  public void initList(E[] els) {
    for (E el : els) {
      elements.add(el);
    }
  }

  public List<E> getList() {
    return elements;
  }

  public int contaElementos(E el) throws IllegalArgumentException {
    if (el == null) {
      throw new IllegalArgumentException("Elemento não pode ser nulo");
    }
    return recursiveElementCount(el, 0);
  }

  private int recursiveElementCount(E el, int index) {
    if (index == elements.size()) {
      return 0;
    }
    E currentElement = elements.get(index);
    int count = currentElement.equals(el) ? 1 : 0;
    return count + recursiveElementCount(el, index + 1);
  }
}
