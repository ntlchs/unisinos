public class Main {

  public static void main(String[] args) {
    System.out.print("\nDigite o código da turma: ");
    String codigoTurma = Keyboard.readString();
    NomesFicticios nomesFicticios = new NomesFicticios();
    int capacidadeMaxima = (int) (Math.random() * 50) + 1;

    Turma turma = new Turma(codigoTurma, capacidadeMaxima);

    System.out.println(
      "\nTurma " +
      turma.getCodigo() +
      " criada. Capacidade máxima de " +
      capacidadeMaxima +
      " alunos"
    );

    int quantidadeAlunos = (int) (Math.random() * 100) + 1;
    System.out.println("Número de alunos inscritos: " + quantidadeAlunos);
    System.out.println("\nCadastrando alunos...");

    String[] nomes = nomesFicticios.nomesAleatorios(quantidadeAlunos);

    for (int i = 0; i < quantidadeAlunos; i++) {
      String nomeAluno = nomes[i];
      Aluno aluno = new Aluno(nomeAluno);

      double notaTrabalho = Math.random() * 10;
      double notaProva = Math.random() * 10;
      double notaAtividades = Math.random() * 10;
      double notaSeminario = Math.random() * 10;
      double notaParticipacao = Math.random() * 10;

      aluno.getGa().setNotaTrabalho(notaTrabalho);
      aluno.getGa().setNotaProva(notaProva);
      aluno.getGb().setNotaAtividades(notaAtividades);
      aluno.getGb().setNotaSeminario(notaSeminario);
      aluno.getGb().setNotaParticipacao(notaParticipacao);

      boolean inserido = turma.insereAluno(aluno);
      if (inserido) {
        System.out.println(
          (i + 1) + "\u00BA " + "Aluno: " + nomeAluno + " inserido na turma."
        );
      } else {
        System.out.println(
          (i + 1) +
          "\u00BA " +
          "Aluno: " +
          nomeAluno +
          " não inserido na turma."
        );
      }
    }

    double mediaNotas = turma.mediaNotasTurma();
    System.out.println("\nMédia de notas da turma: " + mediaNotas);
    System.out.println("\nDesempenho dos alunos: ");
    for (Aluno aluno : turma.getAlunos()) {
      if (aluno != null) {
        double notaFinal = aluno.calculaNotaFinal();
        if (notaFinal >= 6.0) {
          System.out.println(aluno.getNome() + ": Passou por média!");
        } else {
          System.out.println("Aluno " + aluno.getNome() + ": Ficou em Grau C.");
        }
      }
    }
  }
}
