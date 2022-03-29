package com.security.donato.safely.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class PasswordUtils {

    private final PasswordEncoder passwordEncoder;

    public PasswordUtils(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encoder(String senha) {
        return passwordEncoder.encode(senha);
    }


    public Boolean passwordIsMatch(String senhaRecebida, String senhaBanco) {
        log.info(String.valueOf(passwordEncoder.matches(senhaRecebida, senhaBanco)));
        return passwordEncoder.matches(senhaRecebida, senhaBanco);
    }


}
