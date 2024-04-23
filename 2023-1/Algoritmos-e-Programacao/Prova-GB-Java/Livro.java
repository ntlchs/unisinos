public class Livro {
    private String titulo;
    private String autor;
    private float preco;
    private int anoDeCriacao;

    public Livro(String titulo, String autor, float preco, int anoDeCriacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.anoDeCriacao = anoDeCriacao;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public void setAnoDeCriacao(int anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }
}
