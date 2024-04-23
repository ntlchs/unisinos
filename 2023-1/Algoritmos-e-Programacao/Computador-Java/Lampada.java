public class Lampada {
    private boolean ligada;

    public Lampada(boolean ligada) {
        this.ligada = ligada;
    }

    public Lampada() {
        this(false);
    }

    public boolean isLigada() {
        return ligada;
    }

    public void setLigada(boolean ligada) {
        this.ligada = ligada;
    }

    public String toString() {
        return "Lâmpada: " + (ligada ? "ligada" : "desligada");
    }
}
