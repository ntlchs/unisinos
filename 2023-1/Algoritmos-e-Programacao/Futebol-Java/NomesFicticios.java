public class NomesFicticios {
    private String[] nomes = {
            "João", "Maria", "Ana", "Carlos", "Pedro", "Paula", "Fernanda",
            "Ricardo", "Beatriz", "Lucas", "Gabriela", "Roberto", "Isabela",
            "Renato", "Lívia", "Mateus", "Aline", "Eduardo", "Bruna",
            "Rodrigo", "Carla", "Daniel", "Elis", "Marcos", "Larissa",
            "Thiago", "Rafaela", "Bruno", "Patrícia", "Alex", "Camila",
            "André", "Débora", "Leonardo", "Caroline", "Felipe", "Marcela",
            "Rafael", "Natália", "Caio", "Viviane", "Marcelo", "Cristiane",
            "Fábio", "Vanessa", "Antônio", "Eliane", "Luís", "Samantha",
            "Gustavo", "Sandra", "Henrique", "Adriana", "Juliano", "Júlia",
            "Márcio", "Mônica", "Igor", "Isadora", "Vinícius", "Liliane",
            "Guilherme", "Alice", "Victor", "Regina", "César", "Clarissa",
            "Otávio", "Diana", "Ronaldo", "Elaine", "Adriano", "Simone",
            "Hugo", "Yasmin", "Paulo", "Solange", "Maurício", "Talita",
            "Douglas", "Daniella", "Jonas", "Cláudia", "Alan", "Andressa", "Luís",
            "Fernando", "Patricia", "Mariana", "Heloisa", "Cecília", "Lorena",
            "Henrique", "Raul", "Catarina", "Isabel", "Elias", "Valentina",
            "Bernardo", "Henrique", "Alice", "Enzo", "Samuel", "Lara",
            "Nicolas", "Sophia", "Joaquim", "Julia", "Valentina", "Miguel"
    };

    private String[] nomesMeio = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    private String[] sobrenomes = {
            "Silva", "Santos", "Souza", "Costa", "Santana", "Oliveira",
            "Pereira", "Rodrigues", "Ferreira", "Almeida", "Rocha", "Carvalho",
            "Gomes", "Martins", "Ramos", "Mendes", "Castro", "Fernandes",
            "Lima", "Araújo", "Ribeiro", "Neves", "Monteiro", "Moreira",
            "Cardoso", "Pinto", "Cavalcante", "Barbosa", "Nascimento",
            "Cunha", "Dias", "Melo", "Freitas", "Sales", "Nunes", "Borges",
            "Vieira", "Moura", "Machado", "Coelho", "Correia", "Teixeira",
            "Dantas", "Sousa", "Marques", "Bezerra", "Andrade", "Miranda",
            "Barros", "Batista", "Tavares", "Lopes", "Guimarães", "Lima",
            "Siqueira", "Morais", "Leal", "Gonçalves", "Reis", "Caldeira",
            "Correia", "Mota", "Macedo", "Alves", "Domingues", "Oliveira",
            "Rocha", "Cardoso", "Pereira", "Santana", "Barros", "Ferreira",
            "Santos", "Carvalho", "Silva", "Monteiro", "Fernandes", "Ramos",
            "Ribeiro", "Costa", "Rodrigues", "Gomes", "Lima", "Araújo",
            "Fernandes", "Albuquerque", "Sousa", "Melo", "Moraes", "Cordeiro",
            "Vargas", "Franco", "Nogueira", "Macedo", "Pacheco", "Prado",
            "Pereira", "Freitas", "Cavalcanti", "Vasconcelos", "Leite", "Xavier"
    };

    public String[] gerarNomesCompletos(int num) {
        if (num > nomes.length * sobrenomes.length * nomesMeio.length) {
            throw new IllegalArgumentException(
                    "Por favor, insira um número menor ou igual a "
                            + (nomes.length * sobrenomes.length * nomesMeio.length));
        }

        String[] result = new String[num];
        boolean[] used = new boolean[nomes.length * sobrenomes.length * nomesMeio.length];

        for (int i = 0; i < num; i++) {
            int index;

            do {
                index = (int) (Math.random() * (nomes.length * sobrenomes.length * nomesMeio.length));
            } while (used[index]);

            int nomeIndex = index / (sobrenomes.length * nomesMeio.length);
            int sobrenomeIndex = (index / nomesMeio.length) % sobrenomes.length;
            int nomeMeioIndex = index % nomesMeio.length;

            result[i] = nomes[nomeIndex] + " " + nomesMeio[nomeMeioIndex] + ". " + sobrenomes[sobrenomeIndex];
            used[index] = true;
        }

        return result;
    }
}
