package com.cac.C23650G1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Exception personalizada de status 422
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntity extends Exception {
    public ApiUnprocessableEntity (String message){
        super(message);
    }
}