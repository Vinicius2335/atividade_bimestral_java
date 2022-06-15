package model;

import java.util.Objects;

public class Disciplina implements Comparable<Disciplina>{
    private String nome;
    private int cargaHoraria;
    private Professor professor;

    public Disciplina(){}

    public Disciplina(String nome, int cargaHoraria, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    @Override
    public int compareTo(Disciplina o) {
        return nome.compareTo(o.getNome());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return cargaHoraria == that.cargaHoraria && nome.equals(that.nome) && professor.equals(that.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cargaHoraria, professor);
    }

    @Override
    public String toString() {
        return nome +
               ", Carga Horária = " + cargaHoraria +
               ", Professor = " + professor.getNome() +
               ", Titulação = " + professor.getTitulacao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
