package enums;

public enum MenuPrincipal {
    DIRETOR(1),
    COORDENADOR(2),
    PROFESSOR(3),
    ALUNO(4),
    NOTA(5),
    CERTIFICADO(6),
    SAIR(7);

    private final int opcao;

    MenuPrincipal(int opcao) {
        this.opcao = opcao;
    }

    public int getOpcao() {
        return opcao;
    }

    public static MenuPrincipal fromOpcao(int opcao) {
        for (MenuPrincipal m : values()) {
            if (m.opcao == opcao) return m;
        }
        return null;
    }
}