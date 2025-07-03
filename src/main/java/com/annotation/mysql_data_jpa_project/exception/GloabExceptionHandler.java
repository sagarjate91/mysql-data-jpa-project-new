package com.annotation.mysql_data_jpa_project.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GloabExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleException(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(UserNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(PhoneNumberException.class)
    public String handlePhoneNumberException(PhoneNumberException e) {
        return e.getMessage();
    }

}
