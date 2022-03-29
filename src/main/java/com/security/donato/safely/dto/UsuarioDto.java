package com.security.donato.safely.dto;

import com.security.donato.safely.domain.StatusPerfil;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String cpf;


    @NotNull
    private String senha;


    @NotNull
    private String email;


    @NotNull
    private String login;

    private Date dataCriacaoUsuario;

    private Date dataAtualizacaoUsuario;

    @NotNull
    private Long StatusUsuario;
}
