package services;

import models.Aluno;
import models.Curso;
import models.Disciplina;
import models.Professor;
import models.Nota;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaAcademico {

    private Scanner sc;

    // Armazenamento dos dados
    private Map<String, Curso> cursos = new HashMap<>();
    private Map<String, Disciplina> disciplinas = new HashMap<>();
    private Map<String, Professor> professores = new HashMap<>();
    private Map<String, Aluno> alunos = new HashMap<>();
    private Map<String, Nota> notas = new HashMap<>();

    public SistemaAcademico(Scanner sc) {
        this.sc = sc;
    }

    // ====== MENU DIRETOR ======
    public void menuDiretor() {
        int opcao;

        do {
            System.out.println("\n--- MENU DIRETOR ---");
            System.out.println("1. Cadastrar Curso");
            System.out.println("2. Cadastrar Disciplina");
            System.out.println("3. Listar Cursos");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    CursoService.cadastrarCurso(sc, cursos);
                    break;
                case 2:
                    DisciplinaService.cadastrarDisciplina(sc, disciplinas);
                    break;
                case 3:
                    CursoService.listarCursos(cursos);
                    break;
                case 4:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    // ====== MENU COORDENADOR ======
    public void menuCoordenador() {
        int opcao;

        do {
            System.out.println("\n--- MENU COORDENADOR ---");
            System.out.println("1. Vincular Disciplina a Curso");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Listar Professores");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    CursoService.vincularDisciplinaCurso(sc, cursos, disciplinas);
                    break;
                case 2:
                    ProfessorService.cadastrarProfessor(sc, professores);
                    break;
                case 3:
                    ProfessorService.listarProfessores(professores);
                    break;
                case 4:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    // ====== MENU PROFESSOR ======
    public void menuProfessor() {
        int opcao;

        do {
            System.out.println("\n--- MENU PROFESSOR ---");
            System.out.println("1. Vincular Disciplina");
            System.out.println("2. Listar Disciplinas Ministradas");
            System.out.println("3. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    ProfessorService.vincularDisciplinaProfessor(sc, professores, disciplinas);
                    break;
                case 2:
                    ProfessorService.listarProfessores(professores);
                    break;
                case 3:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    // ====== MENU ALUNO ======
    public void menuAluno() {
        int opcao;

        do {
            System.out.println("\n--- MENU ALUNO ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Matricular Disciplina");
            System.out.println("3. Listar Alunos");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    AlunoService.cadastrarAluno(sc, alunos, cursos);
                    break;
                case 2:
                    AlunoService.matricularDisciplinaAluno(sc, alunos, disciplinas);
                    break;
                case 3:
                    AlunoService.listarAlunos(alunos);
                    break;
                case 4:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }
    // ====== MENU NOTAS ======
    public void menuNotas() {
        int opcao;

        do {
            System.out.println("\n--- MENU NOTAS ---");
            System.out.println("1. Lançar Nota para Aluno");
            System.out.println("2. Consultar Notas de Aluno");
            System.out.println("3. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    NotaService.lancarNota(sc, alunos, disciplinas, notas);
                    break;
                case 2:
                    NotaService.consultarNotasAluno(sc, notas);
                    break;
                case 3:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }
}