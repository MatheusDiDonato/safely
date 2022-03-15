package com.security.donato.safely.security.service;

import com.security.donato.safely.domain.Usuario;
import com.security.donato.safely.repository.UsuarioRepository;
import com.security.donato.safely.security.exception.UsuarioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario findUsuarioByLogin(String login) {
        Usuario usuario;
        try {
            usuario = usuarioRepository.findByLogin(login);
        } catch (Exception e) {
            throw new UsuarioException("Usuario não encontrado");
        }
        return usuario;

    }
}
