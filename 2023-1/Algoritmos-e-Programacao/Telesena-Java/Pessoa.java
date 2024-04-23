public class Pessoa {
    private String nome;
    private TeleSena[] telesenas;
    private double premiacao;

    public Pessoa(String nome) {
        this.nome = nome;
        this.telesenas = new TeleSena[0];
        this.premiacao = 0.0;
    }

    public String getNome() {
        return this.nome;
    }

    public void setTeleSenas(TeleSena[] telesenas) {
        this.telesenas = telesenas;
    }

    public TeleSena[] getTeleSenas() {
        return this.telesenas;
    }

    public double getPremiacao() {
        return this.premiacao;
    }

    public void addPremiacao(double valor) {
        this.premiacao += valor;
    }

}
