package test;

import model.AlunoCurso;
import model.Colegiado;
import model.*;

import java.util.List;
import java.util.Map;

public class Test02 {
    public static void main(String[] args) {
        Professor p1 = new Professor("Joao", "123", "18/10/1970", "12", "1234", 25F, 2.99);
        Professor p2 = new Professor("Flavio", "456", "01/101/1972", "29", "5668", 35F, 5.99);

        Disciplina d1 = new Disciplina("Matematica", 200, p1);
        Disciplina d2 = new Disciplina("Portugues", 400, p2);
        Disciplina d3 = new Disciplina("Fisica", 600, p1);

        List<Disciplina> listaD1 = List.of(d1, d3);
        List<Disciplina> listaD2 = List.of(d1, d2, d3);

        Curso c1 = new Curso("Eletrica", listaD1);
        Curso c2 = new Curso("TADS", d1);
        Curso c3 = new Curso("Literatura", d2);
        Curso c4 = new Curso("Arquitetura", listaD2);

        List<Professor> listaProfessores = List.of(p1, p2);

        Colegiado colediado = new Colegiado(c1, listaProfessores);
        Colegiado colediado2 = new Colegiado(c2, listaProfessores);
        Colegiado colediado3 = new Colegiado(c3, listaProfessores);
        Colegiado colediado4 = new Colegiado(c4, listaProfessores);

        Estudante e1 = new Estudante("Vinicius", "456", "04/10/1994", "90", 6, c1);
        Estudante e2 = new Estudante("Maria", "789", "18/12/1996", "10", 7, c2);
        Estudante e3 = new Estudante("Zéziinho", "135", "08/10/1992", "50", 8, c3);
        Estudante e4 = new Estudante("Jade", "246", "20/05/1984", "30", 9, c4);

        String dataHora = "23/12/2021 16:23";
        String dataHora2 = "24/11/2021 17:30";
        String dataHora3 = "23/10/2021 18:40";
        String dataHora4 = "23/09/2021 19:50";
        Aula a1 = new Aula("05", dataHora, d1);
        Aula a2 = new Aula("03", dataHora2, d2);
        Aula a3 = new Aula("07", dataHora3, d3);
        Aula a4 = new Aula("09", dataHora4, d1);
        a1.addAluno(e1);
        a1.addAluno(e2);

        a2.addAluno(e1);
        a2.addAluno(e2);
        a2.addAluno(e3);

        a3.addAluno(e1);
        a3.addAluno(e2);
        a3.addAluno(e3);
        a3.addAluno(e4);

        a4.addAluno(e2);

        AlunoCurso ac1 = new AlunoCurso(c1);
        AlunoCurso ac2 = new AlunoCurso(c2);
        AlunoCurso ac3 = new AlunoCurso(c3);
        AlunoCurso ac4 = new AlunoCurso(c4);
        ac1.inserirAluno(e1);
        ac1.inserirAluno(e2);

        ac2.inserirAluno(e2);
        ac2.inserirAluno(e3);
        ac2.inserirAluno(e4);

        ac3.inserirAluno(e1);
        ac3.inserirAluno(e2);
        ac3.inserirAluno(e3);

        ac4.inserirAluno(e1);
        ac4.inserirAluno(e2);
        ac4.inserirAluno(e3);
        ac4.inserirAluno(e4);


//        System.out.println(ac1);
//        System.out.println(ac2);
//        System.out.println(ac3);
//        System.out.println(ac4);

        for (Map.Entry<String,Estudante> entry: a1.getListaAlunos().entrySet()){
            System.out.println(entry.getValue());
        }
        System.out.println("---------------------");
        for (Map.Entry<String,Estudante> entry: a2.getListaAlunos().entrySet()){
            System.out.println(entry.getValue());
        }
        System.out.println("---------------------");
        for (Map.Entry<String,Estudante> entry: a3.getListaAlunos().entrySet()){
            System.out.println(entry.getValue());
        }
        System.out.println("---------------------");
        for (Map.Entry<String,Estudante> entry: a4.getListaAlunos().entrySet()){
            System.out.println(entry.getValue());
        }

    }
}
