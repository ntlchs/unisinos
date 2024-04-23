// Crie uma classe chamada Sala, que possui um nome e um array de
// Cadeira. No construtor desta classe, receba o nome da sala e a quantidade de cadeiras que
// esta sala possui, inicializando o array com este tamanho. Ainda no construtor, depois de
// instanciar o array de Cadeira com o tamanho indicado, coloque cadeiras nesta sala. Atente
// para os seguintes pontos:
// • A sala terá cadeiras com rodinhas e cadeiras com mesas acopladas. O tipo de cada
// cadeira a ser inserido em cada posição do array deve ser escolhido de forma aleatória
// • As cores das cadeiras devem ser escolhidas de forma aleatória, sendo que o R, o G e o B
// podem assumir valores entre 0 (inclusive) e 255 (inclusive). Demais informações
// necessárias para cada tipo de cadeira devem ser obtidas através de sorteios
// • Crie os métodos de acesso. Sobrescreva o método toString, que retorna o nome da
// sala e a informação de todas as cadeiras que a sala possui

// Na classe Sala, crie um método que retorna a quantidade de cadeiras com
// mesa que estão livres para alguém sentar, ou seja, que não estão ocupadas por algum aluno.
// Chame este método de cadeirasComMesaDisponiveis.

// Na classe Sala, crie um método que retorna a quantidade de cadeiras com
// rodinhas que estão livres para alguém sentar, ou seja, que não estão ocupadas por algum aluno.
// Chame este método de cadeirasComRodinhasDisponiveis

// Na classe sala, crie um método chamado entraAluno, que recebe um
// objeto do tipo Aluno e uma String que representa o tipo de cadeira que ele quer sentar por
// parâmetro. O parâmetro do tipo de cadeira terá dois valores: “mesa” ou “rodinha”. Assim
// sendo, o método deve colocar o aluno recebido por parâmetro em uma cadeira do tipo desejado.
// Caso não tenha cadeira do tipo desejado disponível, o aluno deve sentar em uma cadeira de
// outro tipo que estiver disponível.
// O método retorna um texto, sendo:
// • “ocupou a cadeira desejada”, quando o aluno encontrou uma cadeira do tipo
// desejado livre e ocupou aquela cadeira
// • “ocupou outro tipo de cadeira”, quando o aluno não encontrou uma cadeira
// do tipo desejado livre e ocupou outro tipo de cadeira
// • “não ocupou cadeira alguma”, caso não tenha cadeira de tipo algum disponível
// para o aluno

public class Sala {

  private String nome;
  private Cadeira[] cadeiras;
  private int qtdCadeiras;
  private int cadeirasComMesa = 0;
  private int cadeirasComRodinha = 0;

  public Sala(String nome, int qtdCadeiras) {
    this.nome = nome;
    this.qtdCadeiras = qtdCadeiras;
    this.cadeiras = new Cadeira[qtdCadeiras];
  }

  public String getNome() {
    return this.nome;
  }

  public int getQtdCadeiras() {
    return this.qtdCadeiras;
  }

  public Cadeira[] getCadeiras() {
    return this.cadeiras;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setQtdCadeiras(int qtdCadeiras) {
    this.qtdCadeiras = qtdCadeiras;
  }

  public void setCadeiras() {
    for (int i = 0; i < qtdCadeiras; i++) {
      cadeiras[i] = this.cadeiraAleatoria();
    }
  }

  private Cadeira cadeiraAleatoria() {
    int tipoCadeira = (int) (Math.random() * 2 + 1);

    int valorR = (int) (Math.random() * 255 + 1);
    int valorG = (int) (Math.random() * 255 + 1);
    int valorB = (int) (Math.random() * 255 + 1);

    Cor cor = new Cor(valorR, valorG, valorB);
    Cadeira cadeira = new Cadeira(cor);
    if (tipoCadeira == 1) {
      cadeirasComRodinha++;
      int dia = (int) (Math.random() * 31 + 1);
      int mes = (int) (Math.random() * 12 + 1);
      int ano = (int) (Math.random() * 2023 + 1);

      Data data = new Data(dia, mes, ano);
      cadeira = new CadeiraComRodinhas(cor, data);
    } else {
      cadeirasComMesa++;
      int alturaMesa = (int) (Math.random() * 100 + 1);
      int larguraMesa = (int) (Math.random() * 100 + 1);

      cadeira = new CadeiraComMesa(cor, alturaMesa, larguraMesa);
    }
    return cadeira;
  }

  public String cadeirasToString() {
    String result = "\n";
    for (Cadeira cadeira : cadeiras) {
      result +=
        cadeira == null ? "Sem cadeira" + "\n" : cadeira.toString() + "\n";
    }
    return result;
  }

  public String toString() {
    return (
      nome +
      ": " +
      "capacidade : " +
      qtdCadeiras +
      " cadeiras" +
      cadeirasToString()
    );
  }

  public int cadeirasComMesaDisponiveis() {
    int result = 0;
    for (Cadeira cadeira : cadeiras) {
      if (cadeira instanceof CadeiraComMesa) {
        result++;
      }
    }
    return result;
  }

  public int cadeirasComRodinhasDisponiveis() {
    int result = 0;
    for (Cadeira cadeira : cadeiras) {
      if (cadeira instanceof CadeiraComRodinhas) {
        result++;
      }
    }
    return result;
  }

  public String entraAluno(Aluno aluno, String preferencia) {
    if (cadeirasComMesaDisponiveis() + cadeirasComRodinhasDisponiveis() >= 1) {
      if (preferencia == "mesa") {
        if (cadeirasComMesaDisponiveis() >= 1) {
          for (Cadeira cadeira : cadeiras) {
            if (
              cadeira instanceof CadeiraComMesa && cadeira.getAluno() == null
            ) {
              cadeira.setAluno(aluno);
            }
          }
          return "ocupou a cadeira desejada";
        } else {
          for (Cadeira cadeira : cadeiras) {
            if (cadeira.getAluno() == null) {
              cadeira.setAluno(aluno);
              return "não ocupou a cadeira desejada";
            }
          }
        }
      } else if (preferencia == "rodinhas") {
        if (cadeirasComRodinhasDisponiveis() >= 1) {
          for (Cadeira cadeira : cadeiras) {
            if (
              cadeira instanceof CadeiraComRodinhas &&
              cadeira.getAluno() == null
            ) {
              cadeira.setAluno(aluno);
              return "ocupou a cadeira desejada";
            }
          }
        } else {
          for (Cadeira cadeira : cadeiras) {
            if (cadeira.getAluno() == null) {
              cadeira.setAluno(aluno);
              return "não ocupou a cadeira desejada";
            }
          }
        }
      }
    }
    return "não ocupou cadeira alguma";
  }
}
