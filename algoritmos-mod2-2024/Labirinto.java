import java.io.BufferedReader;
import java.io.FileReader;

public class Labirinto {

  private char[][] maze;

  private char[][] carregaLabirinto(String filename) {
    try {
      FileReader fr = new FileReader(filename);
      BufferedReader br = new BufferedReader(fr);

      int rows = Integer.parseInt(br.readLine().trim());

      int cols = Integer.parseInt(br.readLine().trim());

      System.out.println("Labirinto " + rows + "x" + cols + "\n");

      maze = new char[rows][cols];

      for (int i = 0; i < rows; i++) {
        String line = br.readLine();
        for (int j = 0; j < cols; j++) {
          maze[i][j] = line.charAt(j);
        }
      }

      br.close();

      System.out.println("Labirinto carregado:");
      printMaze();
      System.out.println();
    } catch (Exception e) {
      System.out.println("Erro ao carregar o labirinto: " + e.getMessage());
    }
    return maze;
  }

  public boolean labirinto(String filename) {
    maze = carregaLabirinto(filename);
    return labirinto(maze, 0, 0);
  }

  private boolean labirinto(char[][] maze, int row, int col) {
    if (row < 0 || row >= maze.length || col < 0 || col >= maze[row].length) {
      return false; // fora do labirinto
    }
    if (maze[row][col] == 'X') {
      return false; // parede
    }
    if (maze[row][col] == 'D') {
      return true; // destino
    }
    if (maze[row][col] == 'V') {
      return false; // visitado
    }
    maze[row][col] = 'V'; // marcar como visitado

    printMaze();
    System.out.println();

    return (
      labirinto(maze, row - 1, col) || // cima
      labirinto(maze, row + 1, col) || // baixo
      labirinto(maze, row, col - 1) || // esquerda
      labirinto(maze, row, col + 1) // direita
    );
  }

  public void printMaze() {
    for (char[] row : maze) {
      for (char cell : row) {
        if (cell == 'V') {
          System.out.print("\u001B[31m" + cell + "\u001B[0m");
        } else {
          System.out.print(cell);
        }
      }
      System.out.println();
    }
  }
}
