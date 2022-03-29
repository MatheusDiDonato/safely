package com.security.donato.safely.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class StatusException extends Exception{
   public StatusException(String msg){
       super(msg);
   }
    public StatusException(String msg, int httpStatusCode) {
        super(msg);
        throw new ResponseStatusException(HttpStatus.valueOf(httpStatusCode), msg);
    }
}
