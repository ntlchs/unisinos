public class Computador {
    private String marca;
    private double velocidade;
    private double preco;
    private int anoFabricacao;
    private boolean novo;

    public Computador(String marca, double velocidade, double preco, int anoFabricacao, boolean novo) {
        this.marca = marca;
        this.velocidade = velocidade;
        this.preco = preco;
        this.anoFabricacao = anoFabricacao;
        this.novo = novo;
    }

    public Computador() {
        this("", 0.0, 0.0, 0, false);
    }

    public String getMarca() {
        return marca;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public double getPreco() {
        return preco;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public boolean isNovo() {
        return novo;
    }

    public void aplicaImposto(double imposto) {
        this.preco += imposto;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String
                .format("Computador: " + marca + ", Velocidade: " + velocidade + " GHz, Preço= " + preco + ", Ano: " +
                        anoFabricacao + ", Novo: " + (novo ? "Sim" : "Não"));
    }
}
