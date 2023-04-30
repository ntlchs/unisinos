public class Tamagotchi {
    private String nome;
    private int idade;
    private int peso;
    private int vezesAcordado;

    public Tamagotchi(String nome) {
        this.nome = nome;
        this.idade = 0;
        this.peso = 1;
        this.vezesAcordado = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPeso() {
        return peso;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setVezesAcordado(int vezesAcordado) {
        this.vezesAcordado = vezesAcordado;
    }

    public void incrementaIdade() {
        this.idade++;
    }

    public void aumentaPeso(int peso) {
        this.peso += peso;
    }

    public void diminuiPeso(int peso) {
        this.peso -= peso;
    }

    public boolean estaComSono() {
        if (this.vezesAcordado >= 5) {
            this.vezesAcordado = 0;
            return true;
        }
        return false;
    }

    public void acorda() {
        this.vezesAcordado++;
    }
}

public class Principal {
    public static void main(String[] args) {
        Teclado t = new Teclado();
        System.out.println("Digite o nome do seu Tamagotchi: ");
        String nome = t.leString();

        Tamagotchi tamagotchi = new Tamagotchi(nome);
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            System.out.println("Tamagotchi " + tamagotchi.getNome() + " - Idade: " + tamagotchi.getIdade() + " dias - Peso: " + tamagotchi.getPeso() + " kg");

            // Ações do Tamagotchi
            double acao = Math.random();
            if (acao < 0.33) {
                // Sentir sono
                System.out.println("O " + tamagotchi.getNome() + " está com sono. O que deseja fazer?");
                System.out.println("1 - Dormir");
                System.out.println("2 - Permanecer acordado");
                int opcao = t.leInt();
                if (opcao == 1) {
                    tamagotchi.acorda();
                    tamagotchi.setIdade(tamagotchi.getIdade() + 1);
                System.out.println("O " + tamagotchi.getNome() + " dormiu e acordou mais velho. Ele agora tem " + tamagotchi.getIdade() + " dias.");
            } else {
                tamagotchi.acorda();
                System.out.println("O " + tamagotchi.getNome() + " permaneceu acordado.");
            }
        } else if (acao < 0.66) {
            // Sentir fome
            System.out.println("O " + tamagotchi.getNome() + " está com fome. O que deseja fazer?");
            System.out.println("1 - Comer muito");
            System.out.println("2 - Comer pouco");
            System.out.println("3 - Não comer");
            int opcao = t.leInt();
            if (opcao == 1) {
                tamagotchi.aumentaPeso(5);
                tamagotchi.acorda();
                System.out.println("O " + tamagotchi.getNome() + " comeu muito e ficou sonolento. Ele agora pesa " + tamagotchi.getPeso() + " kg.");
            } else if (opcao == 2) {
                tamagotchi.aumentaPeso(1);
                System.out.println("O " + tamagotchi.getNome() + " comeu pouco e agora pesa " + tamagotchi.getPeso() + " kg.");
            } else {
                tamagotchi.diminuiPeso(2);
                if (tamagotchi.getPeso() <= 0) {
                    System.out.println("O " + tamagotchi.getNome() + " morreu de desnutrição.");
                    jogoAtivo = false;
                    break;
                }
                System.out.println("O " + tamagotchi.getNome() + " não comeu e emagreceu. Ele agora pesa " + tamagotchi.getPeso() + " kg.");
            }
            if (tamagotchi.getPeso() > 20) {
                System.out.println("O " + tamagotchi.getNome() + " explodiu de tanto comer. Fim de jogo.");
                jogoAtivo = false;
                break;
            }
        } else {
            // Ficar entediado
            System.out.println("O " + tamagotchi.getNome() + " está entediado. O que deseja fazer?");
            System.out.println("1 - Correr 10 minutos");
            System.out.println("2 - Caminhar 10 minutos");
            int opcao = t.leInt();
            if (opcao == 1) {
                tamagotchi.diminuiPeso(4);
                tamagotchi.aumentaPeso(5);
                System.out.println("O " + tamagotchi.getNome() + " correu e ficou com fome. Ele agora pesa " + tamagotchi.getPeso() + " kg.");
            } else {
                tamagotchi.diminuiPeso(1);
                System.out.println("O " + tamagotchi.getNome() + " caminhou e emagreceu. Ele agora pesa " + tamagotchi.getPeso() + " kg.");
            }
        }

        tamagotchi.incrementaIdade();
        if (tamagotchi.getIdade() >= 15) {
            System.out.println("O " + tamagotchi.getNome() + " morreu de velhice. Fim de jogo.");
            jogoAtivo = false;
            break;
        }
