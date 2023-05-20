import java.util.Calendar;

public class Estante {
    private String nome;
    private Livro[] livros;
    private int numLivros;

    public Estante(String nome, Livro livro1, Livro livro2, Livro livro3) {
        this.nome = nome;
        this.livros = new Livro[3];
        this.numLivros = 0;
        adicionarLivro(livro1);
        adicionarLivro(livro2);
        adicionarLivro(livro3);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Livro[] getLivros() {
        return livros;
    }

    public void adicionarLivro(Livro livro) {
        if (numLivros < 3) {
            livros[numLivros] = livro;
            numLivros++;
            System.out.println("Livro " + livro.getTitulo() + " adicionado à estante.");
        } else {
            System.out.println("A estante está cheia. Não é possível adicionar mais livros.");
        }
    }

    public boolean verificaLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro != null && titulo.equals(livro.getTitulo())) {
                return true;
            }
        }
        return false;
    }

    public float verificaDesconto(String titulo) {
        for (Livro livro : livros) {
            if (livro instanceof Novo && titulo.equals(livro.getTitulo())) {
                return ((Novo) livro).getDesconto();
            }
        }
        return -1;
    }

    public void imprimeEdicoes() {
        for (Livro livro : livros) {
            if (livro instanceof Antigo) {
                System.out.println("Edição do " + livro.getTitulo() + ": " + ((Antigo) livro).getEdicao());
            }
        }
    }

    public void imprimeLivroPorAno() {
        int contador = 0;
        int ano = Calendar.getInstance().get(Calendar.YEAR);

        while (contador < numLivros && ano >= 1800) {
            for (Livro livro : livros) {
                if (livro != null && livro.getAnoDeCriacao() == ano) {
                    System.out.println(contador + ": " + livro.getTitulo() + " (" + livro.getAnoDeCriacao() + ")");
                    contador++;
                }
            }
            ano--;
        }
    }

    public float calculaMediaPreco() {
        float totalPreco = 0;

        for (Livro livro : livros) {
            if (livro != null) {
                totalPreco += livro.getPreco();
            }
        }

        return totalPreco / numLivros;
    }
}
