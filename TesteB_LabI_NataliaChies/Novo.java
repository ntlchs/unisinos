public class Novo extends Livro {
    private float desconto;

    public Novo(String titulo, String autor, float preco, int anoDeCriacao, float desconto) {
        super(titulo, autor, preco, anoDeCriacao);
        this.desconto = desconto;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

}
