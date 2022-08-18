package controller;

import model.*;

import java.util.List;
import java.util.function.Predicate;

public abstract class Validacoes {
    public static <T> T validacao(List<T> list, Predicate<T> predicate){
        for (T element : list){
            if (predicate.test(element)){
                return element;
            }
        }
        return null;
    }

    public static void relatorio(Curso curso, AlunoCurso alunoCurso, Aula aula){
        System.out.println("_______________ RELÁTORIO DO SISTEMA _______________");
        System.out.println("Curso: " + curso.getNomeCurso());
        curso.recuperarDisciplinas().forEach(System.out::println);

        System.out.println();
        System.out.println("------------ Alunos Cadastrados no Curso ------------");
        alunoCurso.recuperarListaAlunos().values()
                .forEach(estudante -> System.out.println("Aluno " + estudante.getNome() + " RA: " + estudante.getRa()));

        System.out.println();
        System.out.println("--------- Aula ---------");
        System.out.println("Lab " + aula.getLab());
        System.out.println("Data/Hora " + aula.getDataHora());
        System.out.println("Disciplina " + aula.getDisciplina().getNome());

        System.out.println();
        System.out.println("--------- Alunos Cadastrados nas Aulas ---------");
        aula.getListaAlunos().values().forEach(System.out::println);

        System.out.println();
    }
}

//public static Professor validarProfessor(Colegiado colegiado, String nRegistroProfessor){
    //    Optional<Professor> professor = colegiado.recupeararProfessores().stream()
    //            .filter(prof -> prof.getnRegistro().equals(nRegistroProfessor)).findFirst();
    //
    //    return professor.orElse(null);
    //}
    //
    //public static Disciplina validarDisciplina(Curso curso, String nomeDisciplina){
    //    Optional<Disciplina> disciplina = curso.recuperarDisciplinas().stream()
    //            .filter(disp -> nomeDisciplina.equals(disp.getNome())).findFirst();
    //
    //    return disciplina.orElse(null);
    //}
    //
    //public static Curso cursoCadastrado(List<Curso> listaCursos, String nomeCurso){
    //    Optional<Curso> curso = listaCursos.stream()
    //            .filter(c -> nomeCurso.equals(c.getNomeCurso())).findFirst();
    //
    //    return curso.orElse(null);
    //}