package com.security.donato.safely.security.service;

import com.security.donato.safely.domain.Usuario;
import com.security.donato.safely.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioSecurityService {
    private final UsuarioService usuarioService;

    public Usuario findUsuarioByLogin(String login) {
        return usuarioService.findUsuarioByLogin(login);
    }
}
