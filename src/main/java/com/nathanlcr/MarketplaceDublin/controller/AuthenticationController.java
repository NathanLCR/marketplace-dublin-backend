package com.nathanlcr.MarketplaceDublin.controller;

import com.nathanlcr.MarketplaceDublin.service.AuthenticationService;
import com.nathanlcr.MarketplaceDublin.service.Dto.LoginDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.LoginResponseDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserResponseDto;
import com.nathanlcr.MarketplaceDublin.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserDto registerUserDto) {
        return ResponseEntity.ok(authenticationService.signup(registerUserDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authenticationService.login(loginDto));
    }
}