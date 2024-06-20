package com.nathanlcr.MarketplaceDublin.service.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDto {
    private String token;

    private long expiresIn;
}
