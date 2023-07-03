public class Main {

  public static void main(String[] args) {
    Aluno maria = new Aluno("Maria", 18);
    System.out.println(maria.toString());

    Cor vermelho = new Cor(255, 0, 0);
    System.out.println(vermelho.toString());

    Data natal = new Data(25, 12, 2023);
    System.out.println(natal.toString());

    Cadeira cadeira = new Cadeira(vermelho);
    System.out.println(cadeira.toString());
    cadeira.setAluno(maria);
    System.out.println(cadeira.toString());

    CadeiraComMesa cadeiraComMesa = new CadeiraComMesa(vermelho, 40, 120);
    System.out.println(cadeiraComMesa.toString());

    CadeiraComRodinhas cadeiraComRodinhas = new CadeiraComRodinhas(
      vermelho,
      natal
    );
    System.out.println(cadeiraComRodinhas.toString());

    Sala sala = new Sala("Sala de estar", 12);
    sala.setCadeiras();
    System.out.println(sala.toString());
    System.out.println(sala.cadeirasComMesaDisponiveis());
    System.out.println(sala.cadeirasComRodinhasDisponiveis());
    System.out.println(sala.entraAluno(maria, "mesa"));
    System.out.println(sala.entraAluno(maria, "mesa"));
    System.out.println(sala.entraAluno(maria, "mesa"));
    System.out.println(sala.entraAluno(maria, "mesa"));
    System.out.println(sala.entraAluno(maria, "mesa"));
    System.out.println(sala.entraAluno(maria, "mesa"));
    System.out.println(sala.entraAluno(maria, "mesa"));
    System.out.println(sala.entraAluno(maria, "mesa"));
    System.out.println(sala.entraAluno(maria, "mesa"));
    System.out.println(sala.entraAluno(maria, "mesa"));
    System.out.println(sala.entraAluno(maria, "mesa"));
    System.out.println(sala.entraAluno(maria, "mesa"));
    System.out.println(sala.entraAluno(maria, "mesa"));
    System.out.println(sala.entraAluno(maria, "mesa"));
    
  }
}
