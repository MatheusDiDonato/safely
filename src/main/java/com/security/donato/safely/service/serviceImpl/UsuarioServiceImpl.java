package com.security.donato.safely.service.serviceImpl;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import com.security.donato.safely.domain.Usuario;
import com.security.donato.safely.dto.UsuarioDto;
import com.security.donato.safely.exception.CpfInvalidException;
import com.security.donato.safely.repository.StatusRepository;
import com.security.donato.safely.repository.UsuarioRepository;
import com.security.donato.safely.security.exception.UsuarioException;
import com.security.donato.safely.service.UsuarioService;
import com.security.donato.safely.utils.PasswordUtils;
import com.security.donato.safely.utils.UsuarioUtils;
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
    private final UsuarioUtils usuarioUtils;
    private final CPFValidator cpfValidator;

    @Override
    public Boolean cadastrarUsuario(UsuarioDto usuarioDto) throws Exception, CpfInvalidException {
        try {
            cpfValidator.assertValid(usuarioDto.getCpf());
        } catch (InvalidStateException e) {
            log.info(e.getMessage());
            throw new CpfInvalidException("Cpf incorreto.", HttpStatus.NOT_FOUND.value());
        }
        if (usuarioUtils.userExists(usuarioDto.getLogin(), usuarioDto.getCpf(), usuarioDto.getEmail())) {
            Usuario usuario = usuarioRepository.findUsuarioByLoginOrEmailOrCpf(usuarioDto.getLogin(), usuarioDto.getCpf()
                    , usuarioDto.getEmail());
            switch (usuario.getStatusUsuario().getIdStatus().intValue()) {
                case 1:
                    throw new UsuarioException(statusRepository.findDescricaoById(1L), HttpStatus.UNAUTHORIZED.value());
                case 2:
                    throw new UsuarioException(statusRepository.findDescricaoById(2L), HttpStatus.UNAUTHORIZED.value());
                case 3:
                    throw new UsuarioException(statusRepository.findDescricaoById(3L), HttpStatus.UNAUTHORIZED.value());
            }
        }
        usuarioRepository.save(Usuario.builder()
                .cpf(usuarioDto.getCpf())
                .dataAtualizacaoUsuario(LocalDateTime.now())
                .dataCriacaoUsuario(LocalDateTime.now())
                .login(usuarioDto.getLogin())
                .email(usuarioDto.getEmail())
                .senha(passwordUtils.encoder(usuarioDto.getSenha()))
                .StatusUsuario(statusRepository.findById(1L).get())
                .build());
        return true;
    }

    @Override
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
