public class LimaoEntrouNaRoda {

  private Node<Pessoa> head;
  private int numPessoas;

  public LimaoEntrouNaRoda(int quantidade) {
    this.numPessoas = quantidade;
    criarRoda(quantidade);
  }

  private void criarRoda(int quantidade) {
    if (quantidade <= 0) {
      throw new UnderflowException();
    }

    Pessoa primeiraPessoa = new Pessoa("Pessoa 1", gerarIdadeAleatoria(20, 40));
    Node<Pessoa> primeiro = new Node<>(primeiraPessoa);
    head = primeiro;
    Node<Pessoa> atual = head;

    for (int i = 2; i <= quantidade; i++) {
      Pessoa novaPessoa = new Pessoa(
        "Pessoa " + i,
        gerarIdadeAleatoria(20, 40)
      );
      Node<Pessoa> novo = new Node<>(novaPessoa);
      atual.next = novo;
      atual = novo;
    }

    atual.next = head; // completa a roda
  }

  public int passaObjeto(int x) {
    if (numPessoas == 0) {
      return -1;
    }

    Node<Pessoa> atual = head; // começa no início
    for (int i = 0; i < x; i++) {
      atual = atual.next;
    }

    return obterPosicao(atual);
  }

  private int obterPosicao(Node<Pessoa> node) {
    Node<Pessoa> atual = head;
    int posicao = 0;
    while (atual != node) {
      atual = atual.next;
      posicao++;
    }
    return posicao;
  }

  public Pessoa removePosicao(int x) {
    if (numPessoas == 0) {
      return null;
    }

    if (x == 0) {
      if (numPessoas == 1) {
        head = null;
      } else {
        Node<Pessoa> atual = head;
        while (atual.next != head) {
          atual = atual.next;
        }
        head = head.next;
        atual.next = head;
      }
    } else {
      Node<Pessoa> atual = head;
      for (int i = 0; i < x - 1; i++) {
        atual = atual.next;
      }
      atual.next = atual.next.next;
    }

    numPessoas--;

    if (numPessoas == 1) {
      return head.getElement();
    }
    return null;
  }

  public void imprimeRoda() {
    Node<Pessoa> atual = head;
    do {
      System.out.println(obterPosicao(atual) + " - " + atual.getElement());
      atual = atual.next;
    } while (atual != head); // voltou ao início
  }

  private int gerarIdadeAleatoria(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
  }
}
