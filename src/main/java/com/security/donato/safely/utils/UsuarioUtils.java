package com.security.donato.safely.utils;


import com.security.donato.safely.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioUtils {
    private final UsuarioRepository usuarioRepository;

    public Boolean userExists(String login, String cpf, String email) {
        usuarioRepository.findUsuarioByLoginOrEmailOrCpf(login, cpf, email);
        if (Objects.nonNull(usuarioRepository.findUsuarioByLoginOrEmailOrCpf(login, cpf, email))) {
            return true;
        }
        return false;
    }


}
