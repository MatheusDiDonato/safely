package com.security.donato.safely.service;

import com.security.donato.safely.dto.UsuarioDto;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

    Boolean cadastrarUsuario(UsuarioDto usuarioDto) throws Exception;
}
