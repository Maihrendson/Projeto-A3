package models;

public class Disciplina {
    private String codigo;
    private String nome;

    public Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
   
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Disciplina)) return false;
        Disciplina other = (Disciplina) obj;
        return codigo.equals(other.codigo);
    }

    
    public int hashCode() {
        return codigo.hashCode();
    }
}