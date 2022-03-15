package com.security.donato.safely.repository;

import com.security.donato.safely.domain.Contexto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContextoRepository extends JpaRepository<Contexto, Long> {

    @Query(value = "select c from Contexto c where c.idUsuario =:idUsuario")
    List<Contexto> findContextoByIdUsuario(Long idUsuario);
}
