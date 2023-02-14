package br.whitefox.tcc.adopet.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum TipoDeUsuario {
    PADRAO(1, "Usuário Padrão"), ADMIN(2, "Usuário Administrador");
    private int cod;
    private String descricao;

    public Integer getCod() {
        return cod;
    }

    // Método
    public static TipoDeUsuario toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (TipoDeUsuario x : TipoDeUsuario.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + cod);
    }
}
