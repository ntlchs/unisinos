package Tamagotchi;

public class Tamagotchi {
    public String nome;
    public int idade;
    public int peso;
    public int vezesAcordado;

    public Tamagotchi(String nome, int idade, int peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.vezesAcordado = 0;
    }

    public void dormir() {
        System.out.println("O Tamagotchi dormiu.");
        this.idade++;
        this.vezesAcordado = 0;
    }

    public void permanecerAcordado() {
        this.vezesAcordado++;
    }

    // Ao ficar com sono, o tamagotchi pode dormir, adicionando 1 dia de vida, ou
    // ficar acordado.
    // Se o Tamagotchi ficar acordado 5 vezes seguidas,
    public void sentirSono() {
        System.out.println("O Tamagotchi está com sono!");
        if (vezesAcordado == 5) {
            System.out.println("O Tamagotchi sentiu sono 5 vezes seguidas e dormirá automaticamente.");
            dormir();
        } else {
            System.out.println("O que você quer fazer?\n1. Dormir\n2. Permanecer acordado");
            int escolha = Teclado.leInt();
            if (escolha == 1) {
                dormir();
            } else if (escolha == 2) {
                permanecerAcordado();
            }
        }
    }

    public void comerMuito() {
        System.out.println("O Tamagotchi comeu muito.");
        this.engordar(5);
    }

    public void comerPouco() {
        System.out.println(this.nome + " comeu pouco.");
        this.engordar(1);
    }

    public void engordar(int peso) {
        System.out.println(this.nome + " engordou " + peso + " quilos.");
        this.peso += peso;
        peso();
    }

    public void emagrecer(int peso) {
        System.out.println(this.nome + " emagreceu " + peso + " quilos.");
        this.peso -= peso;
        peso();
    }

    public void sentirFome() {
        System.out.println(this.nome + " está com fome!");
        System.out.println("O que você quer fazer?\n1. Comer muito\n2. Comer pouco\n3. Não comer");
        int escolha = Teclado.leInt();
        if (escolha == 1) {
            comerMuito();
            sentirSono();
        } else if (escolha == 2) {
            comerPouco();
            engordar(1);
        } else if (escolha == 3) {
            emagrecer(2);
        }
    }

    public void ficarEntediado() {
        System.out.println(this.nome + " está entediado!");
        System.out.println("Escolha um treino:\n1. Correr 10 minutos\n2. Caminhar 10 minutos");
        int escolha = Teclado.leInt();
        if (escolha == 1) {
            emagrecer(4);
            comerMuito();
        } else if (escolha == 2) {
            emagrecer(1);
            sentirFome();
        } else {
            return;
        }
    }

    public void morrer() {
        System.out.println(this.nome + " morreu.");
        System.exit(0);
    }

    public void vida() {
        if (idade == 15) {
            System.out.println(this.nome + " completou 15 dias de vida e morreu.");
            morrer();
        }
    }

    public void peso() {
        if (peso == 0) {
            System.out.println(this.nome + " chegou a 0 quilos, ficou desnutrido e morreu.");
            morrer();
        } else if (peso == 20) {
            System.out.println(this.nome + " ultrapassou 20 quilos, explodiu e morreu.");

        }
    }
}