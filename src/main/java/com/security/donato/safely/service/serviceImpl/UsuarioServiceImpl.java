package com.security.donato.safely.service.serviceImpl;

import com.security.donato.safely.dto.UsuarioDto;
import com.security.donato.safely.service.UsuarioService;
import com.security.donato.safely.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    @Override
    public Boolean cadastrarUsuario(UsuarioDto usuarioDto) {
     String senha1 =  PasswordUtils.encoder(usuarioDto.getSenha());
     String senha2 = PasswordUtils.encoder(usuarioDto.getSenha());
     log.info(senha1);
     log.info(senha2);
        log.info(PasswordUtils.passwordIsMatch(senha1, senha2).toString());


        return true;
    }
}
