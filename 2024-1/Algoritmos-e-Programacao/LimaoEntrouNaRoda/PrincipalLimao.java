public class PrincipalLimao {

  public static void main(String[] args) {
    int rodada = 1;
    LimaoEntrouNaRoda jogo = new LimaoEntrouNaRoda(10);
    System.out.println("Roda inicial:");
    jogo.imprimeRoda();
    System.out.println("*****");
    boolean acabou = false;
    Pessoa pessoa = null;
    while (!acabou) {
      int posicao = jogo.passaObjeto(14);
      pessoa = jogo.removePosicao(posicao);
      System.out.println("Rodada " + rodada);
      System.out.println("Objeto na posição " + posicao);
      jogo.imprimeRoda();
      System.out.println("************");
      rodada++;
      acabou = pessoa != null; // checa se pessoa é != null
    }
    System.out.println("Vencedor:");
    System.out.println(pessoa);
  }
}
