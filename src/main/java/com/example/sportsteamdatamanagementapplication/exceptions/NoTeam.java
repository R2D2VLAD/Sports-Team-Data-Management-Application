package com.example.sportsteamdatamanagementapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoTeam extends RuntimeException {
    public NoTeam(String message) {
        super(message);
    }
}
