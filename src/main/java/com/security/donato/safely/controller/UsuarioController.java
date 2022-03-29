package com.security.donato.safely.controller;

import com.security.donato.safely.dto.UsuarioDto;
import com.security.donato.safely.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @SneakyThrows
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@Valid @RequestBody UsuarioDto usuarioDto){
        usuarioService.cadastrarUsuario(usuarioDto);
        return ResponseEntity.ok("Usuario cadastrado.");
    }

}
