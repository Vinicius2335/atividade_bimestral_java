package model;

import java.util.Map;
import java.util.TreeMap;

public class AlunoCurso {
    private Curso curso;
    private Map<String, Estudante> alunosCurso = new TreeMap<>();

    public AlunoCurso() {
    }

    public AlunoCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return curso +
                ", AlunosCurso = " + alunosCurso;
    }

    public void inserirAluno(Estudante estudante) {
        alunosCurso.put(estudante.getRa(), estudante);
    }

    public Map<String, Estudante> recuperarListaAlunos() {
        return alunosCurso;
    }

    public Estudante recuperarAluno(String RA) {
        for (Map.Entry<String, Estudante> entry : alunosCurso.entrySet()) {
            if (entry.getValue().getRa().equals(RA)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
