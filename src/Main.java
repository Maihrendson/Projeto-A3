
import enums.MenuPrincipal;
import services.SistemaAcademico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaAcademico sistema = new SistemaAcademico(sc);

        MenuPrincipal opcao;
        do {
            System.out.println("\n===== SISTEMA ACADÊMICO =====");
            System.out.println("1. Diretor");
            System.out.println("2. Coordenador");
            System.out.println("3. Professor");
            System.out.println("4. Aluno");
            System.out.println("5. Nota");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int entrada = Integer.parseInt(sc.nextLine());
                opcao = MenuPrincipal.fromOpcao(entrada);

                if (opcao == null) {
                    System.out.println("Opção inválida!");
                    continue;
                }

                switch (opcao) {
                    case DIRETOR:
                        sistema.menuDiretor();
                        break;
                    case COORDENADOR:
                        sistema.menuCoordenador();
                        break;
                    case PROFESSOR:
                        sistema.menuProfessor();
                        break;
                    case ALUNO:
                        sistema.menuAluno();
                        break;
                    case NOTA:
                        sistema.menuNotas();
                    case SAIR:
                        System.out.println("Saindo do sistema...");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
                opcao = null;
            }

        } while (opcao != MenuPrincipal.SAIR);

        sc.close();
    }
}