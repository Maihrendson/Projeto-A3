package models;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String matricula;
    private String nome;
    private List<Curso> curso;
    private List<Disciplina> disciplinasMatriculadas;

    public Aluno(String matricula, String nome, Curso curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = new ArrayList<>();
        this.curso.add(curso);
        this.disciplinasMatriculadas = new ArrayList<>();
    }

    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso( List<Curso> curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public void matricularDisciplina(Disciplina disciplina) {
        if (!disciplinasMatriculadas.contains(disciplina)) {
            disciplinasMatriculadas.add(disciplina);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Aluno other = (Aluno) obj;
        return matricula != null ? matricula.equals(other.matricula) : other.matricula == null;
    }

    public int hashCode() {
        return matricula != null ? matricula.hashCode() : 0;
    }
}