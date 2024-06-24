package com.nathanlcr.MarketplaceDublin.service.impl;

import com.nathanlcr.MarketplaceDublin.entity.User;
import com.nathanlcr.MarketplaceDublin.error.UserNotFoundException;
import com.nathanlcr.MarketplaceDublin.repository.UserRepository;
import com.nathanlcr.MarketplaceDublin.service.AuthenticationService;
import com.nathanlcr.MarketplaceDublin.service.Dto.LoginDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.LoginResponseDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserResponseDto;
import com.nathanlcr.MarketplaceDublin.service.JwtService;
import com.nathanlcr.MarketplaceDublin.service.mapper.UserMapper;
import com.nathanlcr.MarketplaceDublin.service.mapper.UserResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final UserMapper userMapper;

    private final UserResponseMapper userResponseMapper;

    private final JwtService jwtService;

    public UserResponseDto signup(UserDto input) {
        User newUser = userMapper.toEntity(input);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        return userResponseMapper.toDto(userRepository.save(newUser));
    }

    public UserResponseDto authenticate(LoginDto input) {
        return userResponseMapper.toDto(authenticateUser(input));
    }

    public LoginResponseDto login(LoginDto loginDto) {
        User authenticatedUser = authenticateUser(loginDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        return new LoginResponseDto(jwtToken, jwtService.getExpirationTime());
    }

    private User authenticateUser(LoginDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmailIgnoreCase(input.getEmail())
                .orElseThrow(UserNotFoundException::new);
    }
}
