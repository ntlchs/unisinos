public class JogoDaVelha {

  private char[][] tabuleiro;

  public JogoDaVelha(int tamanho) {
    tabuleiro = new char[tamanho][tamanho];
    for (int i = 0; i < tamanho; i++) {
      for (int j = 0; j < tamanho; j++) {
        tabuleiro[i][j] = '-';
      }
    }
  }

  public boolean realizaJogada(int linha, int coluna, char caractere) {
    if (
      linha < 0 ||
      linha >= tabuleiro.length ||
      coluna < 0 ||
      coluna >= tabuleiro.length
    ) {
      return false;
    }
    if (tabuleiro[linha][coluna] == '-') {
      tabuleiro[linha][coluna] = caractere;
      return true;
    }
    return false;
  }

  public boolean verificaGanhador() {
    // Verifica linhas e colunas
    for (int i = 0; i < tabuleiro.length; i++) {
      if (checkColumn(i) || checkLine(i)) {
        return true;
      }
    }

    // Verifica diagonais
    return checkMainDiagonal() || checkSecondaryDiagonal();
  }

  public boolean checkTie() {
    for (int i = 0; i < tabuleiro.length; i++) {
      for (int j = 0; j < tabuleiro[i].length; j++) {
        if (tabuleiro[i][j] == '-') {
          return false; // Ainda há movimentos possíveis, então não é empate
        }
      }
    }
    return true;
  }

  private boolean checkColumn(int columnIndex) {
    char first = tabuleiro[0][columnIndex];
    for (int i = 1; i < tabuleiro.length; i++) {
      if (tabuleiro[i][columnIndex] != first) {
        return false;
      }
    }
    return first != '-';
  }

  private boolean checkLine(int lineIndex) {
    char first = tabuleiro[lineIndex][0];
    for (int i = 1; i < tabuleiro.length; i++) {
      if (tabuleiro[lineIndex][i] != first) {
        return false;
      }
    }
    return first != '-';
  }

  private boolean checkMainDiagonal() {
    char first = tabuleiro[0][0];
    for (int i = 1; i < tabuleiro.length; i++) {
      if (tabuleiro[i][i] != first) {
        return false;
      }
    }
    return first != '-';
  }

  private boolean checkSecondaryDiagonal() {
    char first = tabuleiro[0][tabuleiro.length - 1]; // Último elemento da primeira linha
    for (int i = 1; i < tabuleiro.length; i++) {
      if (tabuleiro[i][tabuleiro.length - 1 - i] != first) { // Seleciona o último elemento da linha, subtraindo i para percorrer a diagonal inversa
        return false;
      }
    }
    return first != '-';
  }

  public int getSize() {
    return tabuleiro.length;
  }

  @Override
  public String toString() {
    String currentState = "  ";

    for (int i = 0; i < tabuleiro.length; i++) {
      currentState += i + " ";
    }

    currentState += "\n";

    for (int i = 0; i < tabuleiro.length; i++) {
      char[] line = tabuleiro[i];
      currentState += i + " ";
      for (char c : line) {
        switch (c) {
          case 'x':
            currentState += ("\033[35m" + "✕" + " \033[0m"); // Magenta
            break;
          case 'o':
            currentState += ("\033[34m" + "○" + " \033[0m"); // Azul
            break;
          case '-':
            currentState += "⋅ ";
            break;
          default:
            currentState += (c + " ");
            break;
        }
      }
      if (line != tabuleiro[tabuleiro.length - 1]) {
        currentState += "\n";
      }
    }
    return currentState;
  }
}
