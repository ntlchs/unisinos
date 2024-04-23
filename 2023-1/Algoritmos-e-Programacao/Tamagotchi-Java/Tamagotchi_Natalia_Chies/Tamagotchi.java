public class Tamagotchi {
    // Atributos do Tamagotchi
    public String nome;
    public int idade;
    public int peso;
    public int vezesAcordado;
    public boolean vida;
    public boolean fome = false;
    public String motivoDaMorte;

    // Constantes que definem limites e ações
    public static final int IDADE_DE_MORTE = 15;
    public static final int PESO_MINIMO = 1;
    public static final int PESO_MAXIMO = 20;
    public static final int DORMIR = 1;
    public static final int FICAR_ACORDADO = 2;
    public static final int COMER_MUITO = 1;
    public static final int PESO_GANHO_COMER_MUITO = 5;
    public static final int COMER_POUCO = 2;
    public static final int PESO_GANHO_COMER_POUCO = 1;
    public static final int NAO_COMER = 3;
    public static final int PESO_PERDIDO_NAO_COMER = -2;
    public static final int CORRER = 1;
    public static final int PESO_PERDIDO_CORRIDA = -4;
    public static final int CAMINHAR = 2;
    public static final int PESO_PERDIDO_CAMINHAR = -1;
    public static final String VELHICE = "velhice";
    public static final String DESNUTRICAO = "desnutrição";
    public static final String EXCESSO_DE_PESO = "excesso de peso";

    // Construtor do Tamagotchi
    public Tamagotchi(String nome) {
        this.nome = nome;
        this.idade = 0;
        this.peso = 1;
        this.vezesAcordado = 0;
        this.vida = true;
    }

    // Método para lidar com o sono do Tamagotchi
    public void sentirSono(int acao) {
        if (acao == DORMIR) {
            this.vezesAcordado = 0;
            this.idade++;
        } else if (acao == FICAR_ACORDADO) {
            this.vezesAcordado++;
        }
    }

    // Método para alterar o peso do Tamagotchi
    public void mudarPeso(int value) {
        int result = this.peso + value;
        if (result >= PESO_MAXIMO || result < PESO_MINIMO) {
            if (result < PESO_MINIMO) {
                this.peso = 0;
            } else if (result > PESO_MAXIMO) {
                this.peso = PESO_MAXIMO;
            }
            checarSeVivo();
        } else {
            this.peso = result;
        }
    }

    // Método para lidar com a alimentação do Tamagotchi
    public void alimentacao(int acao) {
        this.fome = false;
        if (acao == COMER_MUITO) {
            this.mudarPeso(PESO_GANHO_COMER_MUITO);
            if (this.peso >= 20) {
                checarSeVivo();
            }
            this.sentirSono(DORMIR);
        } else if (acao == COMER_POUCO) {
            this.mudarPeso(PESO_GANHO_COMER_POUCO);
        } else if (acao == NAO_COMER) {
            this.mudarPeso(PESO_PERDIDO_NAO_COMER);
        }
    }

    // Método para lidar com o tédio do Tamagotchi
    public void sentirTedio(int acao) {
        if (acao == CORRER) {
            this.mudarPeso(PESO_PERDIDO_CORRIDA);
            if (this.vida == true) {
                this.alimentacao(COMER_MUITO);
            }
        } else if (acao == CAMINHAR) {
            this.fome = true;
            this.mudarPeso(PESO_PERDIDO_CAMINHAR);
        }
    }

    // Método para verificar se o Tamagotchi ainda está vivo
    public void checarSeVivo() {
        if (this.idade >= IDADE_DE_MORTE) {
            this.vida = false;
            this.motivoDaMorte = VELHICE;
        }
        if (this.peso < PESO_MINIMO) {
            this.vida = false;
            this.motivoDaMorte = DESNUTRICAO;
        }
        if (this.peso >= PESO_MAXIMO) {
            this.vida = false;
            this.motivoDaMorte = EXCESSO_DE_PESO;
        }
    }

}