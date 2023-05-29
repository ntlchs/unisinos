public class NomesFicticios {
    String[] nomesFicticios = {
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
            "Douglas", "Daniella", "Jonas", "Cláudia", "Alan", "Andressa",
            "João Paulo", "Maria Clara", "Ana Paula", "Carlos Alberto", "Pedro Lucas",
            "Paula Fernanda", "Fernanda Beatriz", "Ricardo Roberto", "Beatriz Isabela",
            "Lucas Renato", "Gabriela Lívia", "Roberto Mateus", "Isabela Aline",
            "Renato Eduardo", "Lívia Bruna", "Mateus Rodrigo", "Aline Carla",
            "Eduardo Daniel", "Bruna Elis", "Rodrigo Marcos", "Carla Larissa",
            "Luis Gustavo", "Danielly", "Bernard", "Silvia"
    };

    public String[] nomesAleatorios(int num) {
        if (num > nomesFicticios.length) {
            throw new IllegalArgumentException("Por favor, insira um número menor ou igual a " + nomesFicticios.length);
        }

        String[] result = new String[num];
        boolean[] used = new boolean[nomesFicticios.length];

        for (int i = 0; i < num; i++) {
            int index;

            do {
                index = (int) (Math.random() * nomesFicticios.length);
            } while (used[index]);

            result[i] = nomesFicticios[index];
            used[index] = true;
        }

        return result;
    }
}
