package com.security.donato.safely.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contexto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CONTEXTO")
    private Long idContexto;

    @Column
    private String descricao;

    @Column
    private Long idUsuario;

}
