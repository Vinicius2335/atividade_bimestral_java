package model;

import model.Curso;
import model.Professor;

import java.util.ArrayList;
import java.util.List;

public class Colegiado {
    private Curso curso;
    private List<Professor> professores = new ArrayList<>();

    public Colegiado(){}

    public Colegiado(Curso curso, List<Professor> professores) {
        this.curso = curso;
        this.professores = professores;
    }

    public Colegiado(Curso curso, Professor professor){
        this.curso = curso;
        inserirProfessor(professor);
    }

    @Override
    public String toString() {
        return "Colegiado -> Curso " + curso.getNomeCurso() +
                ", Professores = " + professores;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void inserirProfessor(Professor professor){
        this.professores.add(professor);
    }

    public List<Professor> recupeararProfessores(){
        return this.professores;
    }
}
