public class TesteJogoDaVelha {

  private static int testesPassados = 0;
  private static int testesFalhados = 0;

  public static void main(String[] args) {
    testLineVictory();
    testColumnVictory();
    testMainDiagonalVictory();
    testSecondaryDiagonalVictory();
    testTie();
    testInvalidCoordinates();

    System.out.println("\nResumo dos Testes:");
    System.out.println(
      "Passados: " + testesPassados + ", Falhados: " + testesFalhados
    );
  }

  private static void testLineVictory() {
    JogoDaVelha game = new JogoDaVelha(3);
    game.realizaJogada(0, 0, 'x');
    game.realizaJogada(0, 1, 'x');
    game.realizaJogada(0, 2, 'x');
    printTestResult("Vitória por linha", game.verificaGanhador(), game);
  }

  private static void testColumnVictory() {
    JogoDaVelha game = new JogoDaVelha(3);
    game.realizaJogada(0, 0, 'o');
    game.realizaJogada(1, 0, 'o');
    game.realizaJogada(2, 0, 'o');
    printTestResult("Vitória por coluna", game.verificaGanhador(), game);
  }

  private static void testMainDiagonalVictory() {
    JogoDaVelha game = new JogoDaVelha(3);
    game.realizaJogada(0, 0, 'x');
    game.realizaJogada(1, 1, 'x');
    game.realizaJogada(2, 2, 'x');
    printTestResult(
      "Vitória por diagonal principal",
      game.verificaGanhador(),
      game
    );
  }

  private static void testSecondaryDiagonalVictory() {
    JogoDaVelha game = new JogoDaVelha(3);
    game.realizaJogada(0, 2, 'o');
    game.realizaJogada(1, 1, 'o');
    game.realizaJogada(2, 0, 'o');
    printTestResult(
      "Vitória por diagonal secundária",
      game.verificaGanhador(),
      game
    );
  }

  private static void testTie() {
    JogoDaVelha game = new JogoDaVelha(3);
    // Realiza uma sequência de jogadas que resulta em empate
    game.realizaJogada(0, 0, 'x');
    game.realizaJogada(0, 1, 'o');
    game.realizaJogada(0, 2, 'x');
    game.realizaJogada(1, 0, 'x');
    game.realizaJogada(1, 1, 'x');
    game.realizaJogada(1, 2, 'o');
    game.realizaJogada(2, 0, 'o');
    game.realizaJogada(2, 1, 'x');
    game.realizaJogada(2, 2, 'o');
    printTestResult("Empate", game.checkTie(), game);
  }

  private static void testInvalidCoordinates() {
    JogoDaVelha game = new JogoDaVelha(3);
    boolean resultadoNegativo = game.realizaJogada(-1, -1, 'x');
    boolean resultadoFora = game.realizaJogada(3, 3, 'o');
    printTestResult(
      "Coordenadas negativas inválidas",
      !resultadoNegativo,
      game
    );
    printTestResult(
      "Coordenadas fora do tabuleiro inválidas",
      !resultadoFora,
      game
    );
  }

  private static void printTestResult(
    String testName,
    boolean passed,
    JogoDaVelha game
  ) {
    System.out.println(game.toString());
    if (passed) {
      System.out.println(testName + ": PASSED");
      testesPassados++;
    } else {
      System.out.println(testName + ": ERRoR");
      testesFalhados++;
    }
    System.out.println();
  }
}
