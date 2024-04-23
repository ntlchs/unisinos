public class Main {
    public static void main(String[] args) {
        executarJogo();
    }

    // Método principal para executar o jogo Tamagotchi
    public static void executarJogo() {
        Terminal terminal = new Terminal();
        terminal.escreve("Digite o nome do seu Tamagotchi: ");
        String nome = Teclado.leString();
        Tamagotchi tamagotchi = new Tamagotchi(nome);
        terminal.escreve("\nSeu tamagotchi se chama " + tamagotchi.nome + "!");
        terminal.escreve("\n" +
                tamagotchi.nome + ", " + tamagotchi.idade + " dia(s), " + tamagotchi.peso + "kg");

        // Loop principal do jogo
        while (tamagotchi.vida == true) {
            double acao;
            if (tamagotchi.fome == true) {
                acao = 0.34;
            } else {
                acao = Math.random();
            }

            // Bloco de decisão baseado no valor da variável 'acao'
            if (acao < 0.33) {
                // Código para lidar com o sono do Tamagotchi
                if (tamagotchi.vezesAcordado < 5) {
                    terminal.escreve(tamagotchi.nome + " está com sono!");

                    terminal.escreve("Escolha o que fazer:");
                    terminal.escrevePar(1, "Dormir");
                    terminal.escrevePar(2, "Ficar acordado");

                    int escolha = Teclado.leInt();
                    if (escolha == 1) {
                        tamagotchi.sentirSono(Tamagotchi.DORMIR);
                        terminal.escreve(nome + " dormiu.");
                    } else if (escolha == 2) {
                        if (tamagotchi.vezesAcordado < 4) {
                            terminal.escreve(nome + " ficou acordado.");
                            tamagotchi.sentirSono(Tamagotchi.FICAR_ACORDADO);
                            terminal.escreve("Vezes acordado: " + tamagotchi.vezesAcordado);
                        } else {
                            tamagotchi.sentirSono(Tamagotchi.DORMIR);
                            terminal.escreve(nome + " ficou acordado 5 vezes seguidas e dormirá de exaustão.");
                        }

                    }
                } else {
                    terminal.escreve(nome + " já ficou acordado por 5 vezes seguidas e dormiu automaticamente.");
                    tamagotchi.sentirSono(Tamagotchi.DORMIR);
                    terminal.escreve("");
                }
                terminal.escreve(
                        "\n" + tamagotchi.nome + ", " + tamagotchi.idade + " dia(s), " + tamagotchi.peso + "kg");
            } else if (acao < 0.66) {
                // Código para lidar com a fome do Tamagotchi
                terminal.escreve(tamagotchi.nome + " está com fome!");
                terminal.escreve("Escolha o que fazer:");

                terminal.escrevePar(1, "Comer muito");
                terminal.escrevePar(2, "Comer pouco");
                terminal.escrevePar(3, "Não comer");

                int escolha = Teclado.leInt();
                if (escolha == 1) {
                    tamagotchi.alimentacao(Tamagotchi.COMER_MUITO);
                    terminal.escreve((nome + " comeu muito"));
                    terminal.escreve("Com isso, engordou " + Tamagotchi.PESO_GANHO_COMER_MUITO + " kg e dormiu.");

                } else if (escolha == 2) {
                    tamagotchi.alimentacao(Tamagotchi.COMER_POUCO);
                    terminal.escreve(nome + " comeu pouco.");
                    terminal.escreve("Com isso, engordou " + Tamagotchi.PESO_GANHO_COMER_POUCO + " kg.");

                } else if (escolha == 3) {
                    tamagotchi.alimentacao(Tamagotchi.NAO_COMER);
                    terminal.escreve(nome + " não comeu.");
                    terminal.escreve("Com isso, emagreceu " + -Tamagotchi.PESO_PERDIDO_NAO_COMER + " kg.");
                }
                terminal.escreve(
                        "\n" + tamagotchi.nome + ", " + tamagotchi.idade + " dia(s), " + tamagotchi.peso + "kg");

            } else {
                // Código para lidar com o tédio do Tamagotchi
                terminal.escreve(tamagotchi.nome + " está entediado!");

                terminal.escreve("Escolha o que fazer:");
                terminal.escrevePar(1, "Correr por 10 minutos");
                terminal.escrevePar(2, "Caminhar por 10 minutos");

                int escolha = Teclado.leInt();
                if (escolha == 1) {
                    tamagotchi.sentirTedio(Tamagotchi.CORRER);
                    if (tamagotchi.vida == true) {
                        terminal.escreve(
                                (nome + " correu por 10 minutos e emagreceu " + -Tamagotchi.PESO_PERDIDO_CORRIDA
                                        + "kg."));
                        if (tamagotchi.peso > 0) {
                            terminal.escreve("Com isso, comeu muito, engordou " + Tamagotchi.PESO_GANHO_COMER_MUITO
                                    + " kg e irá dormir.");
                        }

                    }
                } else if (escolha == 2) {
                    tamagotchi.sentirTedio(Tamagotchi.CAMINHAR);
                    terminal.escreve(
                            nome + " caminhou por 10 minutos e emagreceu " + -Tamagotchi.PESO_PERDIDO_CAMINHAR + "kg.");
                    terminal.escreve("Com isso, ficou com fome.");
                    tamagotchi.fome = true;

                }

                terminal.escreve(
                        "\n" + tamagotchi.nome + ", " + tamagotchi.idade + " dia(s), " + tamagotchi.peso + "kg");
            }

            // Verifica se o Tamagotchi ainda está vivo
            if (tamagotchi.vida == false) {
                break;
            }
        }

        // Exibe a mensagem de fim de jogo e a causa da morte do Tamagotchi
        terminal.escreve(nome + " morreu de " + tamagotchi.motivoDaMorte + ".");
        terminal.escreve("Fim de jogo");
    }
}