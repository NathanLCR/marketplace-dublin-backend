package com.nathanlcr.MarketplaceDublin.service.impl;

import com.nathanlcr.MarketplaceDublin.entity.User;
import com.nathanlcr.MarketplaceDublin.repository.UserRepository;
import com.nathanlcr.MarketplaceDublin.service.AuthenticationService;
import com.nathanlcr.MarketplaceDublin.service.Dto.LoginDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.LoginResponseDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserDto;
import com.nathanlcr.MarketplaceDublin.service.JwtService;
import com.nathanlcr.MarketplaceDublin.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final UserMapper userMapper;

    private final JwtService jwtService;

    public UserDto signup(UserDto input) {
        User newUser = userMapper.toEntity(input);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        return userMapper.toDto(userRepository.save(newUser));
    }

    public UserDto authenticate(LoginDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userMapper.toDto(
                userRepository.findByEmailIgnoreCase(input.getEmail())
                .orElseThrow()
        );
    }

    public LoginResponseDto login(LoginDto loginDto) {
        User authenticatedUser = userMapper.toEntity(authenticate(loginDto));
        String jwtToken = jwtService.generateToken(authenticatedUser);

        return new LoginResponseDto(jwtToken, jwtService.getExpirationTime());
    }
}
