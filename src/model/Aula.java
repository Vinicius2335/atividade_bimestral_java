package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Aula {
    private String lab;
    private Date dataHora;
    private Disciplina disciplina;
    private Map<String, Estudante> alunosAula = new TreeMap<>();

    public Aula() {
    }

    public Aula(String lab, String dataHora, Disciplina disciplina) {
        this.lab = lab;
        setDataHora(dataHora);
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        String pattern2 = "dd/MM/yyyy HH:mm";
        SimpleDateFormat format = new SimpleDateFormat(pattern2);
        return "Aula -> " +
                "Laboratorio = '" + lab + '\'' +
                ", Data/Hora = " + format.format(dataHora) +
                ", Disciplina = " + disciplina.getNome() +
                ", Professor = " + disciplina.getProfessor().getNome() +
                ", Alunos = " + alunosAula;
    }

    public void addAluno(Estudante estudante) {
        alunosAula.put(estudante.getRa(), estudante);
    }

    public Map<String, Estudante> getListaAlunos() {
        return this.alunosAula;
    }

    public Estudante getAluno(String RA) throws NullPointerException {
        for (Map.Entry<String, Estudante> entry : alunosAula.entrySet()) {
            if (entry.getValue().getRa().equals(RA)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        String pattern2 = "dd/MM/yyyy HH:mm";
        SimpleDateFormat format = new SimpleDateFormat(pattern2);
        Date data = new Date();
        try {
            data = format.parse(dataHora);
            this.dataHora = data;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
