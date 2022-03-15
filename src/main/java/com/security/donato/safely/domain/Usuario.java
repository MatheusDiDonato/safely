package com.security.donato.safely.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USUARIO")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column
    private String cpf;

    @Column
    private String senha;

    @Column
    private String email;

    @Column
    private String login;

    @Column
    private Date dataCriacaoUsuario;

    @Column
    private Date dataAtualizacaoUsuario;

    @OneToOne
    @JoinColumn(name = "ID_STATUS")
    private StatusPerfil StatusUsuario;

}
