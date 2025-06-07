package services;

import models.Aluno;
import models.Disciplina;
import models.Nota;

import java.util.Map;
import java.util.Scanner;

public class NotaService {

    public static void lancarNota(Scanner sc, Map<String, Aluno> alunos, Map<String, Disciplina> disciplinas, Map<String, Nota> notas) {
        System.out.print("Informe a matrícula do aluno: ");
        String matricula = sc.nextLine();

        Aluno aluno = alunos.get(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.print("Informe o código da disciplina: ");
        String codDisciplina = sc.nextLine();

        Disciplina disciplina = disciplinas.get(codDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.print("Informe o trimestre (1 a 4): ");
        int trimestre;
        try {
            trimestre = Integer.parseInt(sc.nextLine());
            if (trimestre < 1 || trimestre > 4) {
                System.out.println("Trimestre inválido.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida para trimestre.");
            return;
        }

        System.out.print("Informe a nota (0 a 10): ");
        double valorNota;
        try {
            valorNota = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Nota inválida.");
            return;
        }

        if (valorNota < 0 || valorNota > 10) {
            System.out.println("Nota fora do intervalo permitido.");
            return;
        }

        String chave = matricula + "-" + codDisciplina + "-T" + trimestre;
        Nota nota = new Nota(aluno, disciplina, valorNota, trimestre);
        notas.put(chave, nota);

        System.out.println("Nota lançada com sucesso!");
    }

    public static void consultarNotasAluno(Scanner sc, Map<String, Nota> notas) {
        System.out.print("Informe a matrícula do aluno: ");
        String matricula = sc.nextLine();

        boolean encontrou = false;
        for (Map.Entry<String, Nota> entry : notas.entrySet()) {
            if (entry.getKey().startsWith(matricula + "-")) {
                System.out.println(entry.getValue()); // usa o toString() de Nota
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma nota encontrada para este aluno.");
        }
    }
}