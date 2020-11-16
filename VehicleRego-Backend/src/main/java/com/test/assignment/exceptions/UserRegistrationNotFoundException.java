package com.test.assignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="User registration details not found")
public class UserRegistrationNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}
