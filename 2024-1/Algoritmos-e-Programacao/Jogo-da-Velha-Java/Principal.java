import java.io.FileWriter;
import java.io.IOException;

public class Principal {

  public static void main(String[] args) {
    String lineSeparator = "▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁\n";
    System.out.println("Bem-vindo ao Jogo da Velha!\n");
    System.out.println("Digite o nome dos jogadores: ");
    System.out.print("Jogador 1: ");
    String name1 = Keyboard.readString();
    if (name1.isEmpty()) {
      System.out.println("Nome não pode ser vazio! Digite novamente:");
      name1 = Keyboard.readString();
    }
    System.out.print("Jogador 2: ");
    if (name1.isEmpty()) {
      System.out.println("Nome não pode ser vazio! Digite novamente:");
      name1 = Keyboard.readString();
    }
    String name2 = Keyboard.readString();
    if (name2.isEmpty()) {
      System.out.println("Nome não pode ser vazio! Digite novamente:");
      name2 = Keyboard.readString();
    } else if (name1.equals(name2)) {
      System.out.println(
        "Os jogadores não podem ter o mesmo nome! Digite novamente:"
      );
      name2 = Keyboard.readString();
    }

    System.out.println("Jogadores: " + name1 + " e " + name2 + "\n");

    System.out.println("Digite o tamanho do tabuleiro: ");
    int size = Keyboard.readInt();
    while (size < 3) {
      System.out.println(
        "Tamanho inválido! O tabuleiro deve ter no mínimo 3x3."
      );
      System.out.println("Digite o tamanho do tabuleiro: ");
      while (size < 3 || size > 10) {
        System.out.println(
          "Tamanho inválido! O tabuleiro deve ter no mínimo 3x3 e no máximo 10x10."
        );
        System.out.println("Digite o tamanho do tabuleiro: ");
        size = Keyboard.readInt();
      }
    }
    System.out.println(lineSeparator);

    Jogador player1 = new Jogador(name1);
    player1.setSymbol('x');

    Jogador player2 = new Jogador(name2);
    player2.setSymbol('o');

    boolean playing = true;

    while (playing) {
      JogoDaVelha game = new JogoDaVelha(size); // Inicializa um novo jogo
      System.out.println(game.toString() + "\n");

      boolean gameEnded = false;

      while (!gameEnded) {
        gameEnded = gameTurn(game, player1);
        System.out.println(lineSeparator);
        if (gameEnded) break; // Termina o loop se houver vencedor ou empate
        gameEnded = gameTurn(game, player2);
        System.out.println(lineSeparator);
        if (gameEnded) break; // Termina o loop se houver vencedor ou empate
      }

      System.out.println("Jogar novamente? (s/n)");
      String playAgain = Keyboard.readString().toLowerCase();
      if (playAgain.equals("n")) {
        System.out.println("\nFim de jogo!");
        playing = false;
      } else {
        System.out.println("\nReiniciando jogo...");
      }
    }

    System.out.println("Resultado final:");
    System.out.println(player1.toString());
    System.out.println(player2.toString());

    try (FileWriter w = new FileWriter("resultado.txt")) {
      w.write("Resultado final:\n");
      w.write(player1.toString() + "\n");
      w.write(player2.toString() + "\n");
      System.out.println("Resultado escrito no arquivo resultado.txt");
    } catch (IOException e) {
      System.out.println("Ocorreu um erro ao escrever o arquivo de resultado.");
    }
  }

  private static boolean gameTurn(JogoDaVelha game, Jogador player) {
    System.out.println(
      "Vez de " + player.getName() + " (" + player.getSymbol() + ")"
    );

    int[] coordinates = readCoordinates();

    while (
      !game.realizaJogada(coordinates[0], coordinates[1], player.getSymbol())
    ) {
      System.out.println("Jogada inválida! Tente novamente.");
      coordinates = readCoordinates();
    }

    System.out.println(game.toString());

    if (game.verificaGanhador()) {
      System.out.println(
        "Vencedor: " + player.getName() + "(" + player.getSymbol() + ")"
      );
      player.addPonto();
      return true; // Retorna true para indicar fim do jogo
    } else if (game.checkTie()) {
      System.out.println("O jogo terminou em empate!");
      return true; // Retorna true para indicar fim do jogo
    }
    return false; // Jogo continua
  }

  private static int[] readCoordinates() {
    System.out.println(
      "Digite as coordenadas (linha e coluna, separadas por ENTER): "
    );
    int[] coordinates = new int[] { Keyboard.readInt(), Keyboard.readInt() };
    System.out.println();
    return coordinates;
  }
}
