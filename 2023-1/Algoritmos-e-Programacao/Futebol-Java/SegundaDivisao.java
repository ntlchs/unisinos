public class SegundaDivisao extends Time {
    private int anosSeguidosSegundaDivisao;

    public SegundaDivisao(String nome, int quantidadeMaximaSocios, int anosSeguidosSegundaDivisao) {
        super(nome, quantidadeMaximaSocios);
        this.anosSeguidosSegundaDivisao = anosSeguidosSegundaDivisao;
    }

    public int getAnosSeguidosSegundaDivisao() {
        return anosSeguidosSegundaDivisao;
    }

    public void setAnosSeguidosSegundaDivisao(int anosSeguidosSegundaDivisao) {
        this.anosSeguidosSegundaDivisao = anosSeguidosSegundaDivisao;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += "Anos seguidos na Segunda Divisão: " + anosSeguidosSegundaDivisao + "\n";
        return result;
    }
}
