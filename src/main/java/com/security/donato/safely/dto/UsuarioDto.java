package com.security.donato.safely.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @NotEmpty(message = "Cpf não deve estar nulo ou vazio.")
    private String cpf;

    @NotNull
    @NotEmpty
    @NotEmpty(message = "Senha não deve estar nula ou vazia.")
    @Size(min = 8, message = "Senha não pode ter menos que 8 digitos")
    private String senha;


    @NotNull
    @NotEmpty
    @NotEmpty(message = "Email não deve estar nulo ou vazio.")
    private String email;


    @NotNull
    @NotEmpty(message = "Login não deve estar nulo ou vazio.")
    private String login;

    private Date dataCriacaoUsuario;

    private Date dataAtualizacaoUsuario;

    @NotNull
    private Long StatusUsuario;
}
