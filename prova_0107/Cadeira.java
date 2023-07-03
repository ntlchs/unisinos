//  Crie uma classe chamada Cadeira, que possui uma cor (objeto do tipo Cor)
// e um atributo do tipo Aluno, que indica o aluno que está ocupando a cadeira. Sabendo que
// quando uma cadeira é criada ela não está ocupada, crie um construtor que recebe apenas a cor
// da cadeira por parâmetro. Crie os métodos de acesso. Sobrescreva o método toString.

public class Cadeira {

  private Cor cor;
  private Aluno aluno;

  public Cadeira(Cor cor) {
    this.cor = cor;
  }

  public Cor getCor() {
    return this.cor;
  }

  public Aluno getAluno() {
    return this.aluno;
  }

  public void setCor(Cor cor) {
    this.cor = cor;
  }

  public void setAluno(Aluno aluno) {
    this.aluno = aluno;
  }

  @Override
  public String toString() {
    return (
      "Cor da cadeira: " +
      cor +
      (
        aluno == null
          ? ", sem aluno sentado."
          : (", aluno sentado: " + aluno.toString())
      )
    );
  }
}
