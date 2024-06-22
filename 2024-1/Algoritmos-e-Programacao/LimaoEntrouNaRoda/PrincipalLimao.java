public class PrincipalLimao {

  public static void main(String[] args) {
    LimaoEntrouNaRoda l = new LimaoEntrouNaRoda(10);
    l.imprimeRoda();
    System.out.println("*****");
    boolean acabou = false;
    Pessoa p = null;
    while (!acabou) {
      int posicao = l.passaObjeto(14);
      p = l.removePosicao(posicao);
      l.imprimeRoda();
      System.out.println("************");
      acabou = p != null;
    }
    System.out.println(p);
  }
}
