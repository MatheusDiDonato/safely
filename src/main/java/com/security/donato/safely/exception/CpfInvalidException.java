package com.security.donato.safely.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CpfInvalidException extends Throwable {

    public CpfInvalidException(String msg) {
        super(msg);
    }

    public CpfInvalidException(String msg, int httpStatusCode) {
        super(msg);
        throw new ResponseStatusException(HttpStatus.valueOf(httpStatusCode), msg);
    }
}
