package com.security.donato.safely.repository;

import com.security.donato.safely.domain.StatusPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusPerfil, Long> {
}
