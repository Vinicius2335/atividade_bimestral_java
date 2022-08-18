package model;

import java.text.DateFormat;
import java.util.Objects;

public class Estudante extends Pessoa implements Comparable<Estudante>{
    private  String ra;
    private int periodo;
    private Curso curso;

    public Estudante(){}

    public Estudante(String nome, String cpf, String dtNascimente, String ra, int periodo, Curso curso) {
        super(nome, cpf, dtNascimente);
        this.ra = ra;
        this.periodo = periodo;
        this.curso = curso;
    }

    @Override
    public int compareTo(Estudante o) {
        return ra.compareTo(o.getRa());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Estudante estudante = (Estudante) o;
        return periodo == estudante.periodo && ra.equals(estudante.ra) && curso.equals(estudante.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ra, periodo, curso);
    }

    @Override
    public String toString() {
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);

        return "Estudante " + super.getNome() +
                ", RA = '" + ra + '\'' +
                ", Periodo = " + periodo +
                ", Curso = " + curso.getNomeCurso() +
                ", Data de Nascimento = " + formato.format(super.getDtNascimente());
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
