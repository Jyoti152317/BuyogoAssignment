package com.example.buyogo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrainingCenterNotFoundException extends RuntimeException {

    public TrainingCenterNotFoundException(String message) {
        super(message);
    }
}
