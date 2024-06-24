package com.nathanlcr.MarketplaceDublin.service;

import com.nathanlcr.MarketplaceDublin.entity.User;
import com.nathanlcr.MarketplaceDublin.repository.UserRepository;
import com.nathanlcr.MarketplaceDublin.service.Dto.LoginDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.LoginResponseDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserResponseDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public interface AuthenticationService {

    UserResponseDto signup(UserDto input);

    UserResponseDto authenticate(LoginDto input);

    LoginResponseDto login(LoginDto loginDto);
}
