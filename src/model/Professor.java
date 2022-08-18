package model;

import java.util.Date;
import java.util.Objects;

public class Professor extends Pessoa implements Comparable<Professor>{
    private String nRegistro;
    private String titulacao;
    private float horasSemanais;
    private double precoHora;


    public Professor(String nome, String cpf, String dtNascimente) {
        super(nome, cpf, dtNascimente);
    }

    public Professor(String nome, String cpf, String dtNascimente, String nRegistro, String titulacao, float horasSemanais, double precoHora) {
        super(nome, cpf, dtNascimente);
        this.nRegistro = nRegistro;
        this.titulacao = titulacao;
        this.horasSemanais = horasSemanais;
        this.precoHora = precoHora;
    }

    public Professor(){}

    @Override
    public int compareTo(Professor o) {
        return this.getNome().compareTo(o.getNome());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return Float.compare(professor.horasSemanais, horasSemanais) == 0 && Double.compare(professor.precoHora, precoHora) == 0 && Objects.equals(nRegistro, professor.nRegistro) && Objects.equals(titulacao, professor.titulacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nRegistro, titulacao, horasSemanais, precoHora);
    }

    @Override
    public String toString() {
        return "Professor " + super.getNome() +
                ", Horas Semanais = " + horasSemanais +
                ", Titulação = " + titulacao;
    }

    public String getnRegistro() {
        return nRegistro;
    }

    public void setnRegistro(String nRegistro) {
        this.nRegistro = nRegistro;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public float getHorasSemanais() {
        return horasSemanais;
    }

    public void setHorasSemanais(float horasSemanais) {
        this.horasSemanais = horasSemanais;
    }

    public double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;
    }
}
