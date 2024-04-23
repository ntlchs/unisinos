public class Aluno {

  private String nome;
  private GrauA ga;
  private GrauB gb;

  public Aluno(String nome) {
    this.nome = nome;
    this.ga = new GrauA();
    this.gb = new GrauB();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public GrauA getGa() {
    return ga;
  }

  public void setGa(GrauA ga) {
    this.ga = ga;
  }

  public GrauB getGb() {
    return gb;
  }

  public void setGb(GrauB gb) {
    this.gb = gb;
  }

  @Override
  public String toString() {
    return (
      "Aluno = " +
      "nome: " +
      nome +
      ", ga: " +
      ga.toString() +
      ", gb: " +
      gb.toString()
    );
  }

  public double calculaNotaFinal() {
    double notaFinal =
      (ga.calculaNotaFinalGrau() * 0.33) + (gb.calculaNotaFinalGrau() * 0.67);
    return notaFinal;
  }
}
