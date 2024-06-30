package com.nathanlcr.MarketplaceDublin.error;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException{

    private String message;

    public ValidationException(String message) {
        super(message);
        this.message = message;
    }
}
