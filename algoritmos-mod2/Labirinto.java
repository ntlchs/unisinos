import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {
    public Labirinto() {

    }

    public char[][] carregaLabirinto(String fileName) {
        BufferedReader br;
        char[][] maze = {};
        int counter = 0;
        int lineNumber = 0;
        int columnNumber = 0;
        
        try {
            FileReader fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            
            String line = br.readLine();
            while (line != null) {
                if (counter == 0) {
                    lineNumber = Integer.parseInt(line.trim());
                } else if (counter == 1) {
                    columnNumber = Integer.parseInt(line.trim());
                } else {
                    for (char c: line) {
                        maze += c;
                    }
                }
                System.out.println("counter: " + counter);
                System.out.println(line);
                counter++;
				// read next line
				line = br.readLine();
			}

            maze = new char[lineNumber][columnNumber];
            
			br.close();
            
        } catch(IOException e) {
            e.printStackTrace();

        }

        return maze;
    }
}