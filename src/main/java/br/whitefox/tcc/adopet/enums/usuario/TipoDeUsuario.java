package br.whitefox.tcc.adopet.enums.usuario;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum TipoDeUsuario {
    PADRAO( "Usuário Padrão"), ADMIN( "Usuário Administrador");
    private String descricao;
}
