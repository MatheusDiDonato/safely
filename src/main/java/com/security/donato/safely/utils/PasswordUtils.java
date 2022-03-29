package com.security.donato.safely.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;


@Slf4j
@UtilityClass
public class PasswordUtils {

    public String encoder(String senha) {
        BCryptPasswordEncoder bCriptEncoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2Y);
        return bCriptEncoder.encode(senha);
    }


    public Boolean passwordIsMatch(String senhaBanco, String senhaRecebida) {
        BCryptPasswordEncoder bCriptEncoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2Y);
        log.info(String.valueOf(bCriptEncoder.matches(senhaBanco, senhaRecebida)));
        return bCriptEncoder.matches(senhaBanco, senhaRecebida);
    }


}
