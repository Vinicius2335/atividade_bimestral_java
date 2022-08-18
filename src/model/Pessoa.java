package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private Date dtNascimente;

    public Pessoa(){}

    public Pessoa(String nome, String cpf, String dtNascimente) {
        this.nome = nome;
        this.cpf = cpf;
        setDtNascimente(dtNascimente);
    }

    public int getIdade(){
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(this.dtNascimente);
        int idade = 2021 - calendario.get(Calendar.YEAR);
        return idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return nome.equals(pessoa.nome) && cpf.equals(pessoa.cpf) && dtNascimente.equals(pessoa.dtNascimente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, dtNascimente);
    }

    @Override
    public String toString() {
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
        return "Pessoa " + nome + '\'' +
                ", CPF = '" + cpf + '\'' +
                ", Data de Nascimente = " + formato.format(this.dtNascimente);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDtNascimente() {
        return dtNascimente;
    }

    public void setDtNascimente(String dtNascimente) {
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
        Date data = new Date();
        try {
            data = formato.parse(dtNascimente);
            this.dtNascimente = data;
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
