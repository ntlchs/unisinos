public class TeleSena {
    private int[][] conjuntos;

    public TeleSena(int[] conjunto1, int[] conjunto2, int preço) {
        this.conjuntos = new int[][] { conjunto1, conjunto2 };
    }

    public int[][] getConjuntos() {
        return this.conjuntos;
    }

    public String printConjuntos() {
        String result = "";
        for (int i = 0; i < conjuntos.length; i++) {
            result += "Conjunto " + (i + 1) + ": ";
            for (int j = 0; j < conjuntos[i].length; j++) {
                result += conjuntos[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }
}
