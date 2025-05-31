package models;


import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String codigo;
    private String nome;
    private List<Disciplina> disciplinasMinistradas;

    public Professor(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.disciplinasMinistradas = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinasMinistradas.contains(disciplina)) {
            disciplinasMinistradas.add(disciplina);
        }
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Professor other = (Professor) obj;
        return codigo != null ? codigo.equals(other.codigo) : other.codigo == null;
    }

    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}