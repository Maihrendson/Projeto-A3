package services;

import models.Aluno;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CertificadoService {

    public static void emitirCertificado(Aluno aluno) {
        if (aluno == null) {
            System.out.println("Aluno inválido.");
            return;
        }

        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("\n==================== CERTIFICADO DE CONCLUSÃO =====================");
        System.out.println("\nCertificamos que " + aluno.getNome() + " concluiu com êxito o curso de " + aluno.getCurso() + ".");
        System.out.println("Data de emissão: " + dataAtual.format(formatter));
        System.out.println("Parabéns pela conclusão do curso!");
        System.out.println("\n===================================================================");
    }
}
