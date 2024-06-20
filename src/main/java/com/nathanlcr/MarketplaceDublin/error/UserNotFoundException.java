package com.nathanlcr.MarketplaceDublin.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends Exception{
    private String message;
    public UserNotFoundException(String message){
        super();
        this.message = message;
    }
}
