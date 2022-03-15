package com.security.donato.safely.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STATUS_PERFIL")
public class StatusPerfil implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_STATUS")
    private Long idStatus;

    @Column
    private String nome;

    @Column
    private String descricao;
}
