package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Curso {
    private String nomeCurso;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Curso(){}

    public Curso(String nomeCurso, List<Disciplina> disciplinas) {
        this.nomeCurso = nomeCurso;
        this.disciplinas = disciplinas;
    }

    public Curso(String nomeCurso, Disciplina disciplina){
        this.nomeCurso = nomeCurso;
        inserirDisciplina(disciplina);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return nomeCurso.equals(curso.nomeCurso) && disciplinas.equals(curso.disciplinas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeCurso, disciplinas);
    }

    @Override
    public String toString() {
        return "Curso " + nomeCurso +
               ", Disciplinas = " + disciplinas;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public List<Disciplina> recuperarDisciplinas() {
        return disciplinas;
    }

    public void inserirDisciplina(Disciplina disciplinas) {
        this.disciplinas.add(disciplinas);
    }
}
