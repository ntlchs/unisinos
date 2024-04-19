import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {

  private char[][] maze;

  private char[][] carregaLabirinto(String filename)
    throws IOException, FileNotFoundException, Exception {
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);

    int rows = Integer.parseInt(br.readLine().trim());

    int cols = Integer.parseInt(br.readLine().trim());

    System.out.println("Labirinto " + rows + "x" + cols + "\n");

    maze = new char[rows][cols];

    for (int i = 0; i < rows; i++) {
      String line = br.readLine();
      for (int j = 0; j < cols; j++) {
        char c = line.charAt(j);
        if (c != 'X' && c != ' ' && c != 'D') {
          throw new Exception("Caractere inválido: " + c);
        } else {
          maze[i][j] = c;
        }
      }
    }

    br.close();

    System.out.println("Labirinto carregado:");
    printMaze();
    System.out.println();

    return maze;
  }

  public boolean labirinto(String filename)
    throws FileNotFoundException, IOException, Exception {
    maze = carregaLabirinto(filename);
    return labirinto(maze, 0, 0);
  }

  private boolean labirinto(char[][] maze, int row, int col) {
    if (row < 0 || row >= maze.length || col < 0 || col >= maze[row].length) {
      return false; // fora do labirinto
    } else if (maze[row][col] == 'X') {
      return false; // parede
    } else if (maze[row][col] == 'D') {
      return true; // destino
    } else if (maze[row][col] == 'V') {
      return false; // visitado
    }
    maze[row][col] = 'V'; // marcar como visitado

    if (
      labirinto(maze, row - 1, col) || // cima
      labirinto(maze, row + 1, col) || // baixo
      labirinto(maze, row, col - 1) || // esquerda
      labirinto(maze, row, col + 1) // direita
    ) {
      maze[row][col] = 'C'; // caminho
      return true;
    }

    return false;
  }

  public void printMaze() {
    for (char[] row : maze) {
      for (char cell : row) {
        if (cell == 'V') {
          System.out.print("\u001B[31m" + cell + "\u001B[0m");
        } else if (cell == 'C') {
          System.out.print("\u001B[32m" + cell + "\u001B[0m");
        } else {
          System.out.print(cell);
        }
      }
      System.out.println();
    }
  }
}
