package services;

import models.Curso;
import models.Disciplina;

import java.util.Map;
import java.util.Scanner;

public class CursoService {

    public static void cadastrarCurso(Scanner sc, Map<String, Curso> cursos) {
        System.out.print("Código do curso: ");
        String codigoCurso = sc.nextLine();

        System.out.print("Nome do curso: ");
        String nomeCurso = sc.nextLine();

        if (cursos.containsKey(codigoCurso)) {
            System.out.println("Já existe um curso com esse código!");
            return;
        }

        cursos.put(codigoCurso, new Curso(codigoCurso, nomeCurso));
        System.out.println("\nCurso \"" + nomeCurso + "\" cadastrado com sucesso!\n");
    }

    public static void vincularDisciplinaCurso(Scanner sc, Map<String, Curso> cursos, Map<String, Disciplina> disciplinas) {
        System.out.print("Código do curso: ");
        String codigoCurso = sc.nextLine();
        Curso curso = cursos.get(codigoCurso);

        if (curso == null) {
            System.out.println("Curso não encontrado!");
            return;
        }

        System.out.print("Código da disciplina: ");
        String codigoDisciplina = sc.nextLine();
        Disciplina disciplina = disciplinas.get(codigoDisciplina);

        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }

        if (curso.getDisciplinas().contains(disciplina)) {
            System.out.println("Esta disciplina já está vinculada a este curso!");
            return;
        }

        curso.adicionarDisciplina(disciplina);
        System.out.println("Disciplina vinculada ao curso com sucesso!");
    }

    public static void listarCursos(Map<String, Curso> cursos) {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }

        System.out.println("\nCursos cadastrados:");
        for (Curso curso : cursos.values()) {
            System.out.println("\n" + curso.getNome() + " (" + curso.getCodigo() + ")");
            if (curso.getDisciplinas().isEmpty()) {
                System.out.println("  Nenhuma disciplina vinculada");
            } else {
                System.out.println("  Disciplinas:");
                for (Disciplina disciplina : curso.getDisciplinas()) {
                    System.out.println("  - " + disciplina.getNome() + " (" + disciplina.getCodigo() + ")");
                }
            }
        }
    }
}