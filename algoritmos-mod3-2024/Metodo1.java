public class Metodo1<E> {

  private E[] elementos;
  private int tamanho;

  @SuppressWarnings("unchecked")
  public Metodo1(int capacidadeInicial) {
    elementos = (E[]) new Object[capacidadeInicial];
    tamanho = 0;
  }

  public boolean addToList(E elemento) {
    if (tamanho == elementos.length) {
      return false;
    }
    elementos[tamanho++] = elemento;
    return true;
  }

  public int contaElementos(E el) {
    return recursiveElementCount(el, 0);
  }

  private int recursiveElementCount(E el, int index) {
    if (index >= tamanho) {
      return 0;
    }
    return (
      (elementos[index].equals(el) ? 1 : 0) +
      recursiveElementCount(el, index + 1)
    );
  }
}
