// Crie uma classe chamada CadeiraComMesa, que é um tipo de cadeira e
// representa uma cadeira com mesa acoplada. Esta classe possui dois atributos, que representam
// a largura e a profundidade da mesa acoplada. Crie um construtor que recebe parâmetros para
// inicializar todos os atributos. Crie os métodos de acesso necessários. Sobrescreva o método
// toString

public class CadeiraComMesa extends Cadeira {

  private double larguraMesa, alturaMesa;

  public CadeiraComMesa(Cor cor, double larguraMesa, double alturaMesa) {
    super(cor);
    this.larguraMesa = larguraMesa;
    this.alturaMesa = alturaMesa;
  }

  public double getAlturaMesa() {
    return this.alturaMesa;
  }

  public double getLarguraMesa() {
    return this.larguraMesa;
  }

  public void setAlturaMesa(double alturaMesa) {
    this.alturaMesa = alturaMesa;
  }

  public void setLarguraMesa(double larguraMesa) {
    this.larguraMesa = larguraMesa;
  }

  @Override
  public String toString() {
    return (
      "Cor da cadeira com mesa: " +
      this.getCor() +
      ", medidas: (" +
      larguraMesa +
      "x" +
      alturaMesa +
      ")"
    );
  }
}
