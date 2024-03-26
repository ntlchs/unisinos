import java.io.File;
import java.io.FileWriter;

public class PrincipalLabirinto {

  public static void main(String[] args) {
    Labirinto maze = new Labirinto();

    System.out.println("Informe o nome do arquivo do labirinto: ");
    String filename = Keyboard.readString();

    boolean solvedMaze = maze.labirinto(filename);

    try {
      File file = new File("saidaLabirinto.txt");
      FileWriter fr = new FileWriter(file);

      String mazeSolution = solvedMaze
        ? "Existe um caminho para o labirinto"
        : "Não existe um caminho para o labirinto";

      System.out.println(mazeSolution);

      maze.printMaze();

      fr.write(mazeSolution);
      fr.close();
    } catch (Exception e) {
      System.out.println("Erro ao criar arquivo: " + e.getMessage());
    }
  }
}
