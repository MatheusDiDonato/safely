package com.security.donato.safely.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/status")
public class TesteRestController {


    @GetMapping("/help")
    public ResponseEntity<String> comandos() {
        return ResponseEntity.ok(Objects.toString("/versao - demonstra a versao do projeto. \n" +
                "/instancia - demonstra a data em que o projeto foi ao ar."));
    }


}
