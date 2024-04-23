public class Jogador {

  private String nome;
  private int pontos;
  public char symbol;

  public Jogador(String nome) {
    this.nome = nome;
    this.pontos = 0;
    this.symbol = symbol;
  }

  public String getName() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getPontos() {
    return pontos;
  }

  public void addPonto() {
    pontos++;
  }

  public void setSymbol(char symbol) {
    this.symbol = symbol;
  }

  public char getSymbol() {
    return symbol;
  }

  @Override
  public String toString() {
    return nome + ": " + pontos + " pontos";
  }
}
