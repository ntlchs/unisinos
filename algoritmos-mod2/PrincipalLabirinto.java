import java.io.FileNotFoundException;

public class PrincipalLabirinto {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName;
        fileName = "sample.txt";
        // System.out.println("Digite o nome do arquivo");
        // fileName = Keyboard.readString();
        
        Labirinto maze = new Labirinto();
        char[][] result = maze.carregaLabirinto(fileName);

        System.out.println(result.toString());

    }
    
}
