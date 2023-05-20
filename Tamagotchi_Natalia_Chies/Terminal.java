public class Terminal {
    // Método para escrever uma string no terminal
    public void escreve(String text) {
        System.out.println(text);
    }

    // Método para escrever um par chave-valor (ambos strings) no terminal
    public void escrevePar(String chave, String valor) {
        this.escreve(chave + ": " + valor);
    }

    // Método para escrever um par chave-valor (chave string, valor int) no terminal
    public void escrevePar(String chave, int valor) {
        this.escreve(chave + ": " + valor);
    }

    // Método para escrever um par chave-valor (chave int, valor string) no terminal
    public void escrevePar(int chave, String valor) {
        this.escreve(chave + ": " + valor);
    }
}