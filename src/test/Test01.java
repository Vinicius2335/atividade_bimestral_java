package test;

import model.AlunoCurso;
import model.Colegiado;
import model.*;

public class Test01 {
    public static void main(String[] args) {
        Professor p1 = new Professor("Joao","123","18/10/1970","12","1234",25F,2.99);

        Disciplina d1 = new Disciplina("Matematica", 200, p1);

        Curso c1 = new Curso("Eletrica", d1);

        Colegiado colediado = new Colegiado(c1, p1);
//        System.out.println(colediado.recupeararProfessores());

        Estudante e1 = new Estudante("Vinicius","456", "04/10/1994", "90", 6, c1);
//        System.out.println("Idade " + e1.getIdade());

        String dataHora = "23/12/2021 16:23";
        Aula a1 = new Aula("05", dataHora, d1);
//        System.out.println(a1.getDataHora());
        a1.addAluno(e1);
//        System.out.println(a1.getListaAlunos());
        System.out.println(a1.getAluno("1"));

        AlunoCurso ac1 = new AlunoCurso(c1);
        System.out.println(ac1);
        ac1.inserirAluno(e1);
        System.out.println(ac1);



    }
}
