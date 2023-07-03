// Crie uma classe chamada CadeiraComRodinhas, que é um tipo de
// cadeira e representa uma cadeira com rodinhas nos pés. Esta classe possui um atributo que
// representa a data da última manutenção desta cadeira (objeto do tipo Data). Crie um construtor
// que recebe parâmetros para inicializar todos os atributos. Crie os métodos de acesso
// necessários. Sobrescreva o método toString.

public class CadeiraComRodinhas extends Cadeira {

  private Data ultimaManutencao;

  public CadeiraComRodinhas(Cor cor, Data ultimaManutencao) {
    super(cor);
    this.ultimaManutencao = ultimaManutencao;
  }

  public Data getUltimaManutencao() {
    return this.ultimaManutencao;
  }

  public void setUltimaManutencao(Data ultimaManutencao) {
    this.ultimaManutencao = ultimaManutencao;
  }

  @Override
  public String toString() {
    return (
      "Cor da cadeira com rodinhas: " +
      this.getCor().toString() +
      ", última manutenção: " +
      ultimaManutencao.toString()
    );
  }
}
