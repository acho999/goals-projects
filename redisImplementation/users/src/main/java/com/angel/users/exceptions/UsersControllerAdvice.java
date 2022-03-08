package com.angel.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class UsersControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserNotFoundException> userNotFoundException(HttpServletRequest request, UserNotFoundException ex){

        return new ResponseEntity<UserNotFoundException>(ex, HttpStatus.NOT_FOUND);
    }

}
