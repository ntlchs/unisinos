public class PrimeiraDivisao extends Time {
    private int posicaoRankingNacional;

    public PrimeiraDivisao(String nome, int quantidadeMaximaSocios, int posicaoRankingNacional) {
        super(nome, quantidadeMaximaSocios);
        this.posicaoRankingNacional = posicaoRankingNacional;
    }

    public int getPosicaoRankingNacional() {
        return posicaoRankingNacional;
    }

    public void setPosicaoRankingNacional(int posicaoRankingNacional) {
        this.posicaoRankingNacional = posicaoRankingNacional;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += "Posição no Ranking Nacional: " + posicaoRankingNacional + "ª\n";
        return result;
    }
}
