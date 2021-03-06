package com.security.donato.safely.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsuarioException extends RuntimeException{
    public UsuarioException(String msg){
        super(msg);
    }

    public UsuarioException(String msg, int httpStatusCode){
        super(msg);
        throw new ResponseStatusException(HttpStatus.valueOf(httpStatusCode), msg);
    }

}
