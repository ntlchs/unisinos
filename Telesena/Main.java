public class Main {
    public static void main(String[] args) {

        int tamanhoGrupoParticipantes = 3;

        NomesFicticios nomesFicticios = new NomesFicticios();
        String[] nomes = nomesFicticios.nomesAleatorios(tamanhoGrupoParticipantes);

        Pessoa[] pessoas = new Pessoa[tamanhoGrupoParticipantes];
        System.out.println("\nAdicionando " + pessoas.length + " participantes...\n");
        for (int i = 0; i < pessoas.length; i++) {
            pessoas[i] = new Pessoa(nomes[i]);
            System.out.println((i + 1) + ". " + nomes[i]);
        }

        System.out.println("\nVendendo TeleSenas...\n");
        ControleTeleSena controleTeleSena = new ControleTeleSena(pessoas);
        System.out.println("Número de telesenas vendidas: " + controleTeleSena.getQuantidadeVendida() + "\n");

        Pessoa[] participantes = controleTeleSena.getPessoas();
        System.out.println("Detalhes da venda: ");

        for (int i = 0; i < participantes.length; i++) {
            Pessoa participante = participantes[i];
            TeleSena[] teleSenas = participante.getTeleSenas();

            String result = (i + 1) + ". " + participante.getNome() + " (" + teleSenas.length
                    + " TeleSenas)\n" + "Números apostados:\n";
            for (int j = 0; j < teleSenas.length; j++) {
                result += "TeleSena " + (j + 1) + ": \n" + teleSenas[j].printConjuntos() + '\n';
            }

            System.out.println(result);
        }

        System.out.println("Realizando sorteio...\n");
        int[] sorteio;
        Pessoa[] ganhadores;

        do {
            sorteio = controleTeleSena.sortearNumeros();
            System.out.print("Números sorteados: ");
            for (int i = 0; i < sorteio.length; i++) {
                System.out.print(sorteio[i] + " ");
            }
            System.out.println("\n");

            System.out.println("Verificando sorteio...\n");
            ganhadores = controleTeleSena.verificarSorteio(sorteio);
            if (ganhadores.length <= 0) {
                System.out.println("Sem vencedores nessa rodada. Realizando novo sorteio.\n");
            } else {
                System.out.println("Vencedores:");
                for (Pessoa ganhador : ganhadores) {
                    System.out.println(ganhador.getNome());
                }
            }
        } while (ganhadores.length <= 0);

        double premio = controleTeleSena.calcularPremio(ganhadores, controleTeleSena.getQuantidadeVendida());
        controleTeleSena.distribuirPremio(ganhadores, premio);
    }
}
