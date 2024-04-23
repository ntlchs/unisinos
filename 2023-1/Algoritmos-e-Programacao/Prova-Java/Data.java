// Crie uma classe chamada Data. Uma data possui 3 inteiros, referentes ao dia,
// mês e ano. Crie um construtor que recebe parâmetros para inicializar todos os atributos.
// Crie os métodos de acesso. Sobrescreva o método toString, que retorna a data no formato
// “dia/mês/ano”

public class Data {

  private int dia, mes, ano;

  public Data(int dia, int mes, int ano) {
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }

  public int getDia() {
    return this.dia;
  }

  public int getMes() {
    return this.mes;
  }

  public int getAno() {
    return this.ano;
  }

  public void setDia(int dia) {
    this.dia = dia;
  }

  public void setMes(int mes) {
    this.mes = mes;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  @Override
  public String toString() {
    return dia + "/" + mes + "/" + ano;
  }
}
