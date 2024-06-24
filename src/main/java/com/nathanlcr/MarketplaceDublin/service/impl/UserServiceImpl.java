package com.nathanlcr.MarketplaceDublin.service.impl;

import com.nathanlcr.MarketplaceDublin.entity.User;
import com.nathanlcr.MarketplaceDublin.error.NotCurrentUserException;
import com.nathanlcr.MarketplaceDublin.error.UserNotFoundException;
import com.nathanlcr.MarketplaceDublin.repository.UserRepository;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserResponseDto;
import com.nathanlcr.MarketplaceDublin.service.UserService;
import com.nathanlcr.MarketplaceDublin.service.mapper.UserResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserResponseMapper userResponseMapper;

    @Override
    public UserResponseDto editUser(UserDto user) {
        UserResponseDto userAuthenticated = getUserAuthenticated();
        userAuthenticated.getEmail().equals(user.getEmail());
        if(userAuthenticated.getId().equals(user.getId())) {
            throw new NotCurrentUserException();
        }
//        User savedUser = userRepository.save(user);
//        return userMapper.toDto(userRepository.save(user));
        return userAuthenticated;
    }

    @Override
    public UserResponseDto getUser(Integer id) {
        return null;
    }

    @Override
    public UserResponseDto getUserAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();
        return userResponseMapper.toDto(currentUser);
    }

    @Override
    public Page<UserResponseDto> getUsers() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmailIgnoreCase(username).orElseThrow(UserNotFoundException::new);
    }
}
