public class Turma {

  private String codigo;
  private Aluno[] alunos;

  public Turma(String codigo, int quantidadeMaximaAlunos) {
    this.codigo = codigo;
    this.alunos = new Aluno[quantidadeMaximaAlunos];
  }

  public boolean insereAluno(Aluno aluno) {
    for (int i = 0; i < alunos.length; i++) {
      if (alunos[i] == null) {
        alunos[i] = aluno;
        return true;
      }
    }
    return false;
  }

  public Aluno[] getAlunos() {
    return alunos;
  }

  public String getCodigo() {
    return codigo;
  }

  public double mediaNotasTurma() {
    int contador = 0;
    double somaNotas = 0;

    for (Aluno aluno : alunos) {
      if (aluno != null) {
        double notaFinal = aluno.calculaNotaFinal();
        somaNotas += notaFinal;
        contador++;
      }
    }

    if (contador > 0) {
      return somaNotas / contador;
    } else {
      return -1.0;
    }
  }

  public void alteraNotasGrauA(
    String nomeAluno,
    double notaTrabalho,
    double notaProva
  ) {
    for (Aluno aluno : alunos) {
      if (aluno != null && aluno.getNome().equals(nomeAluno)) {
        aluno.getGa().setNotaTrabalho(notaTrabalho);
        aluno.getGa().setNotaProva(notaProva);
        break;
      }
    }
  }

  public void alteraNotasGrauB(
    String nomeAluno,
    double notaAtividades,
    double notaSeminario,
    double notaParticipacao
  ) {
    for (Aluno aluno : alunos) {
      if (aluno != null && aluno.getNome().equals(nomeAluno)) {
        aluno.getGb().setNotaAtividades(notaAtividades);
        aluno.getGb().setNotaSeminario(notaSeminario);
        aluno.getGb().setNotaParticipacao(notaParticipacao);
        break;
      }
    }
  }
}
