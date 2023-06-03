public class Time {
    private String nome;
    private int quantidadeMaximaSocios;
    private Socio[] socios;

    public Time(String nome, int quantidadeMaximaSocios) {
        this.nome = nome;
        this.quantidadeMaximaSocios = quantidadeMaximaSocios;
        this.socios = new Socio[quantidadeMaximaSocios];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeMaxSocios() {
        return this.quantidadeMaximaSocios;
    }

    public void seQuantidadeMaxSocios(int novaQuantidadeMax) {
        this.quantidadeMaximaSocios = novaQuantidadeMax;
    }

    public Socio[] getSocios() {
        return this.socios;
    }

    public boolean insereSocio(Socio socio) {
        for (int i = 0; i < socios.length; i++) {
            if (socios[i] == null) {
                socios[i] = socio;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "\nNome do Time: " + nome + "\n";
        result += "Número máximo de sócios: " + quantidadeMaximaSocios + "\n";
        return result;
    }

    public void imprimeSocios() {
        String result = "Sócios do " + nome + ":\n";
        for (int i = 0; i < quantidadeMaximaSocios; i++) {
            if (socios[i] != null) {
                result += (i + 1) + ": " + socios[i].toString() + "\n";
            } else {
                result += (i + 1) + ": (vazio)\n";
            }
        }
        System.out.println(result);
    }

}
