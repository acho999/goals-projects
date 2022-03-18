package com.angel.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String message){
        super(message);
    }

    public UserNotFoundException(String message, Throwable couse){
        super(message, couse);
    }

    public UserNotFoundException(Throwable couse){
        super(couse);
    }

}
