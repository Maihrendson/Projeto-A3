package services;

import models.Aluno;
import models.Curso;
import models.Disciplina;

import java.util.Map;
import java.util.Scanner;

public class AlunoService {

    public static void cadastrarAluno(Scanner sc, Map<String, Aluno> alunos, Map<String, Curso> cursos) {
        System.out.print("Matrícula do aluno: ");
        String matricula = sc.nextLine();

        if (alunos.containsKey(matricula)) {
            System.out.println("Já existe um aluno com essa matrícula!");
            return;
        }

        System.out.print("Nome do aluno: ");
        String nome = sc.nextLine();

        System.out.print("Código do curso: ");
        String codigoCurso = sc.nextLine();
        Curso curso = cursos.get(codigoCurso);
        
        if (curso == null) {
            System.out.println("Curso não encontrado!");
            return;
        }

        alunos.put(matricula, new Aluno(matricula, nome, curso));
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public static void listarAlunos(Map<String, Aluno> alunos) {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("\nAlunos cadastrados:");
        for (Aluno aluno : alunos.values()) {
            System.out.println(aluno.getNome());
            System.out.print(aluno.getCurso());
        }
    }

    public static void matricularDisciplinaAluno(Scanner sc, Map<String, Aluno> alunos, Map<String, Disciplina> disciplinas) {
    System.out.print("Matrícula do aluno: ");
    String matricula = sc.nextLine();

    Aluno aluno = alunos.get(matricula);
    if (aluno == null) {
        System.out.println("Aluno não encontrado!");
        return;
    }

    System.out.print("Código da disciplina: ");
    String codigoDisciplina = sc.nextLine();

    Disciplina disciplina = disciplinas.get(codigoDisciplina);
    if (disciplina == null) {
        System.out.println("Disciplina não encontrada!");
        return;
    }

    aluno.matricularDisciplina(disciplina);
    System.out.println("Disciplina matriculada com sucesso!");
    }
}