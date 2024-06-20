package com.nathanlcr.MarketplaceDublin.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotCurrentUserException extends RuntimeException{

    public NotCurrentUserException(){
        super("Not Current User");
    }

    public NotCurrentUserException(final String message) {

        this(message, null);
    }

    public NotCurrentUserException(final String message, final Throwable cause) {

        super(message, cause);
    }
}
