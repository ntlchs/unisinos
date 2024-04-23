public class Main {
    public static void main(String[] args) {
        int quantidadeTimes = 0;
        while (quantidadeTimes < 1 || quantidadeTimes > 50) {
            System.out.print("Digite a quantidade de times (entre 1 e 50): ");
            quantidadeTimes = Keyboard.readInt();
            if (quantidadeTimes < 1 || quantidadeTimes > 50) {
                System.out.println("Número deve estar entre 1 e 50");
            }
        }

        Time[] times = new Time[quantidadeTimes];
        NomesFicticios nomesFicticios = new NomesFicticios();
        String[] nomesCompletos = nomesFicticios.gerarNomesCompletos(20 * quantidadeTimes);

        for (int i = 0; i < quantidadeTimes; i++) {
            System.out.println("\n=== Criação do Time " + (i + 1) + " ===");
            System.out.print("Digite o nome do time: ");
            String nomeTime = Keyboard.readString();

            int quantidadeMaxSocios = 0;
            while (quantidadeMaxSocios < 1) {
                System.out.print("Digite a quantidade máxima de sócios do time (maior que 0): ");
                quantidadeMaxSocios = Keyboard.readInt();
            }

            int tipoTime = (int) (Math.random() * 2);
            System.out.println("Classificação: " + (tipoTime == 0 ? "Segunda Divisão" : "Primeira Divisão"));

            if (tipoTime == 0) {
                int anosSeguidosSegundaDivisao = (int) (Math.random() * 10) + 1;
                times[i] = new SegundaDivisao(nomeTime, quantidadeMaxSocios, anosSeguidosSegundaDivisao);
            } else {
                int posicaoRankingNacional = (int) (Math.random() * 100) + 1;
                times[i] = new PrimeiraDivisao(nomeTime, quantidadeMaxSocios, posicaoRankingNacional);
            }

            System.out.println("Inserindo sócios...");

            for (int j = 0; j < 20; j++) {
                String nomeSocio = nomesCompletos[i * 20 + j];
                System.out.print((j + 1) + ": " + nomeSocio + " - ");
                int idadeSocio = (int) (Math.random() * 80) + 18;

                Socio socio = new Socio(nomeSocio, idadeSocio);
                boolean inserido = times[i].insereSocio(socio);

                System.out.println(inserido ? "Sócio inserido com sucesso"
                        : "Falha ao inserir sócio. Limite atingido (máx=" + times[i].getQuantidadeMaxSocios() + ")");
            }
        }

        System.out.println("\n=== Informações dos Times ===");
        for (Time time : times) {
            System.out.println(time.toString());
        }

        System.out.println("\n=== Informações dos Sócios ===");
        for (Time time : times) {
            time.imprimeSocios();
        }

        System.out.println("\n=== Sócios mais Velhos ===");
        for (Time time : times) {
            Socio socioMaisVelho = null;

            for (Socio socio : time.getSocios()) {
                if (socio != null && (socioMaisVelho == null || socio.getIdade() > socioMaisVelho.getIdade())) {
                    socioMaisVelho = socio;
                }
            }

            if (socioMaisVelho != null) {
                System.out.println(time.getNome() + ": " + socioMaisVelho.getNome() + " é o sócio mais velho, com "
                        + socioMaisVelho.getIdade() + " anos");
            }
        }

        System.out.println("\n=== Time com melhor colocação no ranking nacional ===");
        PrimeiraDivisao melhorColocado = null;
        for (Time time : times) {
            if (time instanceof PrimeiraDivisao) {
                PrimeiraDivisao primeiraDivisao = (PrimeiraDivisao) time;
                if (melhorColocado == null
                        || primeiraDivisao.getPosicaoRankingNacional() < melhorColocado.getPosicaoRankingNacional()) {
                    melhorColocado = primeiraDivisao;
                }
            }
        }

        if (melhorColocado != null) {
            System.out.println(melhorColocado.toString());
        } else {
            System.out.println("Nenhum time da primeira divisão encontrado.");
        }
    }
}
