package com.security.donato.safely.repository;

import com.security.donato.safely.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select u from Usuario u where u.login =: login")
    Usuario findByLogin(String login);

    @Query(value = "select u from Usuario u where u.login =:login or u.cpf =:cpf or u.email =:email")
    Usuario findUsuarioByLoginOrEmailOrCpf(String login, String cpf, String email);
}
