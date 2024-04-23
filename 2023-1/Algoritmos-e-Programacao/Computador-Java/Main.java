public class Main {

    public static void main(String[] args) {

        // Criar 3 instâncias de cada produto (Cor, Computador, Lampada)
        int r1 = Teclado.leInt("Digite o valor de R para a primeira cor:");
        int g1 = Teclado.leInt("Digite o valor de G para a primeira cor:");
        int b1 = Teclado.leInt("Digite o valor de B para a primeira cor:");

        Cor cor1 = new Cor(r1, g1, b1);

        int r2 = Teclado.leInt("Digite o valor de R para a segunda cor:");
        int g2 = Teclado.leInt("Digite o valor de G para a segunda cor:");
        int b2 = Teclado.leInt("Digite o valor de B para a segunda cor:");

        Cor cor2 = new Cor(r2, g2, b2);

        int r3 = Teclado.leInt("Digite o valor de R para a terceira cor:");
        int g3 = Teclado.leInt("Digite o valor de G para a terceira cor:");
        int b3 = Teclado.leInt("Digite o valor de B para a terceira cor:");

        Cor cor3 = new Cor(r3, g3, b3);

        String marca1 = Teclado.leString("Digite a marca do computador:");
        double velocidade1 = Teclado.leDouble("Digite a velocidade do processador do computador:");
        double preco1 = Teclado.leDouble("Digite o preço do computador:");
        int anoFabricacao1 = Teclado.leInt("Digite o ano de fabricação do computador:");
        boolean novo1 = Teclado.leString("O computador é novo? (true/false)").equals("true");
        Computador computador1 = new Computador(marca1, velocidade1, preco1, anoFabricacao1, novo1);

        String marca2 = Teclado.leString("Digite a marca do computador:");
        double velocidade2 = Teclado.leDouble("Digite a velocidade do processador do computador:");
        double preco2 = Teclado.leDouble("Digite o preço do computador:");
        int anoFabricacao2 = Teclado.leInt("Digite o ano de fabricação do computador:");
        boolean novo2 = Teclado.leString("O computador é novo? (true/false)").equals("true");

        Computador computador2 = new Computador(marca2, velocidade2, preco2, anoFabricacao2, novo2);

        String marca3 = Teclado.leString("Digite a marca do computador:");
        double velocidade3 = Teclado.leDouble("Digite a velocidade do processador do computador:");
        double preco3 = Teclado.leDouble("Digite o preço do computador:");
        int anoFabricacao3 = Teclado.leInt("Digite o ano de fabricação do computador:");
        boolean novo3 = Teclado.leString("O computador é novo? (true/false)").equals("true");

        Computador computador3 = new Computador(marca3, velocidade3, preco3, anoFabricacao3, novo3);

        boolean ligada1 = Teclado.leString("Digite o estado da primeira lâmpada (true/false): ").equals("true");
        Lampada lampada1 = new Lampada(ligada1);
        boolean ligada2 = Teclado.leString("Digite o estado da segunda lâmpada (true/false): ").equals("true");
        Lampada lampada2 = new Lampada(ligada2);
        boolean ligada3 = Teclado.leString("Digite o estado da terceira lâmpada (true/false): ").equals("true");
        Lampada lampada3 = new Lampada(ligada3);

        String nome1 = Teclado.leString("Digite o nome do primeiro produto: ");
        double valor1 = Teclado.leDouble("Digite o valor do primeiro produto: ");
        String descrição1 = Teclado.leString("Digite a descrição do primeiro produto: ");
        int quantidadeEmEstoque1 = Teclado.leInt("Digite a quantidade em estoque do primeiro produto: ");

        Produto produto1 = new Produto(nome1, valor1, descrição1, quantidadeEmEstoque1);

        String nome2 = Teclado.leString("Digite o nome do segundo produto: ");
        double valor2 = Teclado.leDouble("Digite o valor do segundo produto: ");
        String descrição2 = Teclado.leString("Digite a descrição do segundo produto: ");
        int quantidadeEmEstoque2 = Teclado.leInt("Digite a quantidade em estoque do segundo produto: ");

        Produto produto2 = new Produto(nome2, valor2, descrição2, quantidadeEmEstoque2);

        String nome3 = Teclado.leString("Digite o nome do terceiro produto: ");
        double valor3 = Teclado.leDouble("Digite o valor do terceiro produto: ");
        String descrição3 = Teclado.leString("Digite a descrição do terceiro produto: ");
        int quantidadeEmEstoque3 = Teclado.leInt("Digite a quantidade em estoque do terceiro produto: ");

        Produto produto3 = new Produto(nome3, valor3, descrição3, quantidadeEmEstoque3);

        // Imprimir informações dos objetos criados
        System.out.println("Informações dos objetos criados:\n");
        System.out.println("Cor 1: " + cor1.toString());
        System.out.println("Cor 2: " + cor2.toString());
        System.out.println("Cor 3: " + cor3.toString());

        System.out.println("\nComputador 1: " + computador1.toString());
        System.out.println("Computador 2: " + computador2.toString());
        System.out.println("Computador 3: " + computador3.toString());

        System.out.println("\nLâmpada 1: " + lampada1.toString());
        System.out.println("Lâmpada 2: " + lampada2.toString());
        System.out.println("Lâmpada 3: " + lampada3.toString());

        System.out.println("\nProduto 1: " + produto1.toString());
        System.out.println("Produto 2: " + produto2.toString());
        System.out.println("Produto 3: " + produto3.toString());

        // Alterar informações de 3 objetos
        // Imprimir informações novas
        double novoPreco = Teclado.leDouble("Digite o novo preço do primeiro computador:");
        computador1.setPreco(novoPreco);

        System.out.println("\nInformações atualizadas do primeiro computador:");
        System.out.println("Preço: " + computador1.getPreco());

        String novoEstado = Teclado.leString("Digite o novo estado da segunda lâmpada (true/false):");
        lampada2.setLigada(novoEstado.equals("true"));

        System.out.println("\nInformações atualizadas da segunda lâmpada:");
        System.out.println("Estado: " + (lampada2.isLigada() ? "ligada" : "desligada"));

        int novoR = Teclado.leInt("Digite o novo valor para o atributo 'r' da primeira cor:");
        cor1.setR(novoR);

        System.out.println("\nInformações atualizadas da primeira cor:");
        System.out.println("Valor de 'r': " + cor1.getR());

        // Aplicar imposto em um dos computadores
        double imposto1 = Teclado.leDouble("Digite o valor de imposto a ser aplicado:");
        computador1.aplicaImposto(imposto1);

        System.out.println("\nPreço atualizado do primeiro computador (com imposto): " + computador1.getPreco());
    }

}
