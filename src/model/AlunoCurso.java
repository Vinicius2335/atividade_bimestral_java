package model;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class AlunoCurso {
    private Curso curso;

    // key -> RA do estudante, Value -> estudante
    private Map<String, Estudante> alunosCurso = new TreeMap<>();

    public AlunoCurso() {
    }

    public AlunoCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudante recuperarAluno(String ra) {
        Optional<Map.Entry<String, Estudante>> estudanteEntry = alunosCurso.entrySet().stream()
                .filter(entry -> ra.equals(entry.getValue().getRa())).findFirst();

        return estudanteEntry.map(Map.Entry::getValue).orElse(null);
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
