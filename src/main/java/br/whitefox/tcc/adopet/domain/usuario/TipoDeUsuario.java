package br.whitefox.tcc.adopet.domain.usuario;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum TipoDeUsuario {
    PADRAO( "Usuário Padrão"), ADMIN( "Usuário Administrador");
    private String descricao;
}
