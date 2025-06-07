package services;

import models.Curso;
import models.Disciplina;
import models.Professor;

import java.util.Map;
import java.util.Scanner;

public class ProfessorService {

    public static void cadastrarProfessor(Scanner sc, Map<String, Professor> professores, Map<String, Curso> cursos) {
        System.out.print("Código do professor: ");
        String codigo = sc.nextLine();

        System.out.print("Nome do professor: ");
        String nome = sc.nextLine();

        System.out.print("Curso do Professor: ");
        String codigocursoProf = sc.nextLine();
        Curso cursoProf = cursos.get(codigocursoProf);
        if (cursoProf == null)
            System.out.println("Curso não encontrado. Tente Novamente!");

        if (professores.containsKey(codigo)) {
            System.out.println("Já existe um professor com esse código!");
            return;
        }

        professores.put(codigo, new Professor(codigo, nome, cursoProf));
        System.out.println("\nProfessor \"" + nome + "\" cadastrado com sucesso!\n");
    }

    public static void vincularDisciplinaProfessor(Scanner sc, Map<String, Professor> professores, Map<String, Disciplina> disciplinas) {
        System.out.print("Código do professor: ");
        String codigoProfessor = sc.nextLine();
        Professor professor = professores.get(codigoProfessor);

        if (professor == null) {
            System.out.println("Professor não encontrado!");
            return;
        }

        System.out.print("Código da disciplina: ");
        String codigoDisciplina = sc.nextLine();
        Disciplina disciplina = disciplinas.get(codigoDisciplina);

        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }

        if (professor.getDisciplinasMinistradas().contains(disciplina)) {
            System.out.println("Esta disciplina já está vinculada a este professor!");
            return;
        }

        professor.adicionarDisciplina(disciplina);
        System.out.println("Disciplina vinculada ao professor com sucesso!");
    }

    public static void listarProfessores(Map<String, Professor> professores) {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        System.out.println("\nProfessores cadastrados:");
        for (Professor professor : professores.values()) {
            System.out.println("\n" + professor.getNome() + " (" + professor.getCodigo() + ")");
            if (professor.getDisciplinasMinistradas().isEmpty()) {
                System.out.println("  Nenhuma disciplina vinculada");
            } else {
                System.out.println("  Disciplinas ministradas:");
                for (Disciplina disciplina : professor.getDisciplinasMinistradas()) {
                    System.out.println("  - " + disciplina.getNome() + " (" + disciplina.getCodigo() + ")");
                }
            }
        }
    }
}
