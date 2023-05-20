public class Antigo extends Livro {
    private int edicao;

    public Antigo(String titulo, String autor, float preco, int anoDeCriacao, int edicao) {
        super(titulo, autor, preco, anoDeCriacao);
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
}
