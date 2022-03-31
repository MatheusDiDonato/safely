package com.security.donato.safely.service;

import com.security.donato.safely.domain.Usuario;
import com.security.donato.safely.dto.UsuarioDto;
import com.security.donato.safely.exception.CpfInvalidException;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

    Boolean cadastrarUsuario(UsuarioDto usuarioDto) throws Exception, CpfInvalidException;

    Usuario findUsuarioByLogin(String login);
}
