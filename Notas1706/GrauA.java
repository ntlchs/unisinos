public class GrauA extends Grau {

  private double notaTrabalho;
  private double notaProva;

  public GrauA(
    String dataInicio,
    String dataFim,
    double notaTrabalho,
    double notaProva
  ) {
    super(dataInicio, dataFim);
    this.notaTrabalho = notaTrabalho;
    this.notaProva = notaProva;
  }

  public GrauA() {
    super();
    this.notaTrabalho = 0;
    this.notaProva = 0;
  }

  public double getNotaTrabalho() {
    return notaTrabalho;
  }

  public void setNotaTrabalho(double notaTrabalho) {
    this.notaTrabalho = notaTrabalho;
  }

  public double getNotaProva() {
    return notaProva;
  }

  public void setNotaProva(double notaProva) {
    this.notaProva = notaProva;
  }

  @Override
  public String toString() {
    return (
      "Grau A = " +
      "dataInicio: " +
      getDataInicio() +
      ", dataFim: " +
      getDataFim() +
      ", notaTrabalho: " +
      notaTrabalho +
      ", notaProva: " +
      notaProva
    );
  }

  public double calculaNotaFinalGrau() {
    double notaFinal = (notaTrabalho * 0.3) + (notaProva * 0.7);
    return notaFinal;
  }
}
