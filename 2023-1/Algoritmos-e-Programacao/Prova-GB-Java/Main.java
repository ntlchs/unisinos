public class Main {
    public static void main(String[] args) {
        Estante estante = criarEstante();
        pesquisarLivro(estante);
        System.out.println("\nLivros em ordem decrescente de ano de criação:");
        estante.imprimeLivroPorAno();
        float mediaPreco = estante.calculaMediaPreco();
        System.out.println("\nMédia de preço dos livros: " + mediaPreco);
        System.out.println("\nEdições dos livros antigos: ");
        estante.imprimeEdicoes();
        pesquisarDesconto(estante);
    }

    private static Estante criarEstante() {
        System.out.print("Digite o nome da estante: ");
        String nomeEstante = Teclado.readString();

        Livro livro1 = criarLivro();
        Livro livro2 = criarLivro();
        Livro livro3 = criarLivro();

        Estante estante = new Estante(nomeEstante, livro1, livro2, livro3);
        System.out.println("Estante criada: " + estante.getNome());

        return estante;
    }

    private static Livro criarLivro() {
        boolean isNovo = Math.random() < 0.5;
        String estadoDoLivro = isNovo ? "Novo" : "Antigo";

        System.out.println("\nInforme os dados do livro " + estadoDoLivro + ": ");
        System.out.print("Título: ");
        String titulo = Teclado.readString();
        System.out.print("Autor: ");
        String autor = Teclado.readString();
        System.out.print("Preço: ");
        float preco = Teclado.readFloat();
        System.out.print("Ano de criação: ");
        int anoDeCriacao = Teclado.readInt();
        if (isNovo) {
            System.out.print("Desconto: ");
            float desconto = Teclado.readFloat();
            return new Novo(titulo, autor, preco, anoDeCriacao, desconto);
        } else {
            System.out.print("Número de Edição: ");
            int numeroDeEdicao = Teclado.readInt();
            return new Antigo(titulo, autor, preco, anoDeCriacao, numeroDeEdicao);
        }
    }

    private static void pesquisarLivro(Estante estante) {
        System.out.print("\nDigite o título do livro a ser pesquisado: ");
        String titulo = Teclado.readString();
        if (estante.verificaLivro(titulo)) {
            System.out.println("Livro encontrado na estante.");
            Livro livroEncontrado = obterLivroPorTitulo(estante, titulo);
            System.out.println("Informações do livro:");
            System.out.println("Título: " + livroEncontrado.getTitulo());
            System.out.println("Autor: " + livroEncontrado.getAutor());
            System.out.println("Preço: " + livroEncontrado.getPreco());
            System.out.println("Ano de criação: " + livroEncontrado.getAnoDeCriacao());
        } else {
            System.out.println("Livro não encontrado na estante.");
        }
    }

    private static Livro obterLivroPorTitulo(Estante estante, String titulo) {
        for (Livro livro : estante.getLivros()) {
            if (livro != null && titulo.equals(livro.getTitulo())) {
                return livro;
            }
        }
        return null;
    }

    private static void pesquisarDesconto(Estante estante) {
        System.out.print("Digite o título do livro para verificar o desconto: ");
        String titulo = Teclado.readString();
        float desconto = estante.verificaDesconto(titulo);
        if (desconto != -1) {
            System.out.println("Desconto do livro '" + titulo + "': " + desconto);
        } else {
            System.out.println("Livro com título '" + titulo + "' não encontrado ou não possui desconto.");
        }
    }
}
