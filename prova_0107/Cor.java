// Questão 2 (0.3pt). Crie uma classe chamada Cor, que possui 3 inteiros, referentes à quantidade
// de R, G e B da cor. Crie um construtor que recebe parâmetros para inicializar todos os atributos.
// Crie os métodos de acesso. Sobrescreva o método toString

public class Cor {

  private int r, g, b;

  public Cor(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public int getR() {
    return this.r;
  }

  public int getG() {
    return this.r;
  }

  public int getB() {
    return this.r;
  }

  public void setR(int r) {
    this.r = r;
  }

  public void setG(int g) {
    this.g = g;
  }

  public void setB(int b) {
    this.b = b;
  }

  @Override
  public String toString() {
    return "(R=" + r + ", G=" + g + ", B=" + b + ")";
  }
}
