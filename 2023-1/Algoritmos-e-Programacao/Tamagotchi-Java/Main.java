package Tamagotchi;

public class Main {
    public static void main(String[] args) {
        System.out.println("Digite o nome do seu Tamagotchi: ");
        String nome = Teclado.leString();
        Tamagotchi tamagotchi = new Tamagotchi(nome, 0, 1);

        while (true) {
            double acao = Math.random();
            if (acao < 0.33) {
                tamagotchi.sentirSono();
            } else if (acao < 0.66) {
                tamagotchi.sentirFome();
            } else {
                tamagotchi.ficarEntediado();
            }

            tamagotchi.vida();
            tamagotchi.peso();

            if (tamagotchi.idade == 15 || tamagotchi.peso == 0 || tamagotchi.peso == 20) {
                break;
            }

            System.out.println("Nome: " + tamagotchi.nome);
            System.out.println("Idade: " + tamagotchi.idade);
            System.out.println("Peso: " + tamagotchi.peso);
            System.out.println();
        }
    }
}
