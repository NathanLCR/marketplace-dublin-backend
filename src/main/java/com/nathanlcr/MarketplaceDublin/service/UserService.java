package com.nathanlcr.MarketplaceDublin.service;

import com.nathanlcr.MarketplaceDublin.entity.User;
import com.nathanlcr.MarketplaceDublin.error.UserNotFoundException;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserResponseDto;
import org.springframework.data.domain.Page;

public interface UserService {

    UserResponseDto editUser(UserDto user);

    UserResponseDto getUser(Integer id);

    Page<UserResponseDto> getUsers();

    UserResponseDto getUserAuthenticated();
}
