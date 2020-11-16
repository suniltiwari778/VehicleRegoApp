package com.test.assignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(value = UserRegistrationNotFoundException.class)
    public ResponseEntity<Object> exception(UserRegistrationNotFoundException exception) {
        return new ResponseEntity<>("User registration detail not found", HttpStatus.NOT_FOUND);
    }
}
