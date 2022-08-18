package controller;

import model.*;

import java.util.List;

public abstract class Validacoes {
    public static Professor validarProfessor(Colegiado colegiado, String nRegistroProfessor){
        for(Professor prof : colegiado.recupeararProfessores()){
            if (nRegistroProfessor.equals(prof.getnRegistro())){
                return prof;
            }
        }
        return null;
    }

    public static Disciplina validarDisciplina(Curso curso, String nomeDisciplina){
        for (Disciplina discip : curso.recuperarDisciplinas()){
            if (nomeDisciplina.equals(discip.getNome())){
                return discip;
            }
        }
        return null;
    }

    public static Curso cursoCadastrado(List<Curso> listaCursos, String nomeCurso){
        for (Curso curso : listaCursos) {
            if (nomeCurso.equals(curso.getNomeCurso())){
                return curso;
            }
        }
        return null;
    }

    public static void relatorio(Curso curso, AlunoCurso alunoCurso, Aula aula){
        System.out.println("_______________ RELÁTORIO DO SISTEMA _______________");
        System.out.println("Curso: " + curso.getNomeCurso());
        for (Disciplina disciplina : curso.recuperarDisciplinas()) {
            System.out.println(disciplina);
        }

        System.out.println();
        System.out.println("------------ Alunos Cadastrados no Curso ------------");
        for (Estudante estudante : alunoCurso.recuperarListaAlunos().values()){
            System.out.println("Aluno " + estudante.getNome() + " RA: " + estudante.getRa());
        }

        System.out.println();
        System.out.println("--------- Aula ---------");
        System.out.println("Lab " + aula.getLab());
        System.out.println("Data/Hora " + aula.getDataHora());
        System.out.println("Disciplina " + aula.getDisciplina().getNome());

        System.out.println();
        System.out.println("--------- Alunos Cadastrados nas Aulas ---------");
        for (Estudante estudante : aula.getListaAlunos().values()) {
            System.out.println(estudante);
        }

        System.out.println();
    }
}
