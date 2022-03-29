package com.security.donato.safely.service.serviceImpl;

import com.security.donato.safely.domain.Usuario;
import com.security.donato.safely.dto.UsuarioDto;
import com.security.donato.safely.execption.StatusException;
import com.security.donato.safely.repository.StatusRepository;
import com.security.donato.safely.repository.UsuarioRepository;
import com.security.donato.safely.service.UsuarioService;
import com.security.donato.safely.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final PasswordUtils passwordUtils;
    private final StatusRepository statusRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public Boolean cadastrarUsuario(UsuarioDto usuarioDto) throws Exception {
            usuarioRepository.save(Usuario.builder()
                    .cpf(usuarioDto.getCpf())
                    .dataAtualizacaoUsuario(LocalDateTime.now())
                    .dataCriacaoUsuario(LocalDateTime.now())
                    .email(usuarioDto.getEmail())
                    .senha(passwordUtils.encoder(usuarioDto.getSenha()))
                    .StatusUsuario(statusRepository.findById(usuarioDto.getStatusUsuario()).orElseThrow(() -> new StatusException("Status não encontrado", HttpStatus.NOT_FOUND.value())))
                    .build());
            return true;
    }
}
