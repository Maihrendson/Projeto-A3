package services;

import models.Disciplina;

import java.util.Map;
import java.util.Scanner;

public class DisciplinaService {

    public static void cadastrarDisciplina(Scanner sc, Map<String, Disciplina> disciplinas) {
        System.out.print("Código da disciplina: ");
        String codigoDisciplina = sc.nextLine();

        System.out.print("Nome da disciplina: ");
        String nomeDisciplina = sc.nextLine();

        if (disciplinas.containsKey(codigoDisciplina)) {
            System.out.println("Já existe uma disciplina com esse código!");
            return;
        }

        disciplinas.put(codigoDisciplina, new Disciplina(codigoDisciplina, nomeDisciplina));
        System.out.println("\nDisciplina \"" + nomeDisciplina + "\" cadastrada com sucesso!\n");
    }

    public static void listarDisciplinas(Map<String, Disciplina> disciplinas) {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        System.out.println("\nDisciplinas cadastradas:");
        for (Disciplina d : disciplinas.values()) {
            System.out.println(d.getNome() + " (" + d.getCodigo() + ")");
        }
    }
}