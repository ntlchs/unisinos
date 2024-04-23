public class Cor {
    private int r, g, b;

    public Cor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Cor() {
        this(0, 0, 0);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String toString() {
        return String.format("Cor: R=" + r + " G=" + g + " B=" + b);
    }
}