public class ControleTeleSena {
    private final int numMaxTelesenas = 15;
    public final int tamanhoTeleSena = 5;
    public final int tamanhoAposta = 2;
    public final int precoPorTeleSena = 10;

    private Pessoa[] pessoas;
    private int quantidadeVendida;

    public ControleTeleSena(Pessoa[] pessoas) {
        this.pessoas = pessoas;
        this.quantidadeVendida = 0;
        venderTeleSena();
    }

    public Pessoa[] getPessoas() {
        return pessoas;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void venderTeleSena() {
        int numMaxVendasPorPessoa = numMaxTelesenas / pessoas.length;

        for (Pessoa pessoa : pessoas) {
            int numTelesenasCompradas = (int) (Math.random() * numMaxVendasPorPessoa + 1);

            TeleSena[] telesenas = new TeleSena[numTelesenasCompradas];
            for (int i = 0; i < numTelesenasCompradas; i++) {
                telesenas[i] = new TeleSena(sortearNumeros(), sortearNumeros(), 10);
            }
            pessoa.setTeleSenas(telesenas);

            quantidadeVendida += numTelesenasCompradas;
        }
    }

    public int[] sortearNumeros() {
        int[] numerosSorteados = new int[tamanhoAposta];
        int count = 0;

        while (count < tamanhoAposta) {
            int numero = (int) (Math.random() * tamanhoTeleSena + 1);
            if (!contem(numerosSorteados, numero)) {
                numerosSorteados[count] = numero;
                count++;
            }
        }

        // Faz bubble sort para colocar os números em ordem
        for (int i = 0; i < numerosSorteados.length - 1; i++) {
            for (int j = 0; j < numerosSorteados.length - 1 - i; j++) {
                if (numerosSorteados[j] > numerosSorteados[j + 1]) {
                    int temp = numerosSorteados[j];
                    numerosSorteados[j] = numerosSorteados[j + 1];
                    numerosSorteados[j + 1] = temp;
                }
            }
        }

        return numerosSorteados;
    }

    public Pessoa[] verificarSorteio(int[] numerosSorteados) {
        Pessoa[] ganhadores = new Pessoa[0];
        for (Pessoa pessoa : pessoas) {
            boolean premiada = false;
            TeleSena[] teleSenas = pessoa.getTeleSenas();
            System.out.println("Analisando TeleSenas de " + pessoa.getNome() + "...");
            for (int i = 0; i < teleSenas.length; i++) {
                TeleSena teleSena = teleSenas[i];
                int[][] conjuntos = teleSena.getConjuntos();
                for (int j = 0; j < conjuntos.length; j++) {
                    int[] conjunto = conjuntos[j];
                    if (saoIguais(numerosSorteados, conjunto)) {
                        premiada = true;
                        System.out.println("TeleSena " + (i + 1) + ": Premiada, conjunto "
                                + (j + 1) + ": ");
                        for (int k = 0; k < numerosSorteados.length; k++) {
                            System.out.print(conjunto[k] + " ");
                        }
                        System.out.println("\n");
                        System.out.println("Adicionando " + pessoa.getNome() + " aos ganhadores...\n");
                        ganhadores = addGanhador(ganhadores, pessoa);
                    }
                }
            }
            if (!premiada) {
                System.out.println("Não premiada(s)");
            }
        }
        return ganhadores;
    }

    private Pessoa[] addGanhador(Pessoa[] ganhadores, Pessoa ganhador) {
        Pessoa[] ganhadoresAtualizada = new Pessoa[ganhadores.length + 1];
        for (int i = 0; i < ganhadores.length; i++) {
            ganhadoresAtualizada[i] = ganhadores[i];
        }
        ganhadoresAtualizada[ganhadores.length] = ganhador;
        System.out.println("Lista de ganhadores atualizada: ");
        for (Pessoa p : ganhadoresAtualizada) {
            System.out.println(p.getNome());
        }
        System.out.println("\n");
        return ganhadoresAtualizada;
    }

    public double calcularPremio(Pessoa[] ganhadores, int quantidadeVendida) {
        double total = precoPorTeleSena * quantidadeVendida;
        System.out.println("Total arrecadado: " + total);

        if (ganhadores.length <= 0) {
            return 0;
        }
        System.out.println("Quantidade de TeleSenas vencedoras: " + ganhadores.length);

        double totalLucro = total * 0.2;
        System.out.println("Total do lucro (20%): R$" + totalLucro);

        double totalPremio = total * 0.8;
        System.out.println("Total do premio (80%): R$" + totalPremio);

        double totalGanhador = totalPremio / ganhadores.length;
        System.out.println("Prêmio de cada TeleSena: R$" + totalGanhador);

        return totalGanhador;

    }

    public void distribuirPremio(Pessoa[] ganhadores, double totalGanhador) {
        for (Pessoa ganhador : ganhadores) {
            System.out.println("Foram adicionados R$" + totalGanhador + " ao prêmio de " + ganhador.getNome() + " ");
            ganhador.addPremiacao(totalGanhador);
            System.out.println("Nova premiação do ganhador: " + ganhador.getPremiacao());
        }
    }

    private boolean saoIguais(int[] numerosSorteados, int[] conjunto) {
        for (int i = 0; i < numerosSorteados.length; i++) {
            if (numerosSorteados[i] != conjunto[i]) {
                return false;
            }
        }
        return true;

    }

    private boolean contem(int[] array, int number) {
        for (int element : array) {
            if (element == number) {
                return true;
            }
        }
        return false;
    }
}
