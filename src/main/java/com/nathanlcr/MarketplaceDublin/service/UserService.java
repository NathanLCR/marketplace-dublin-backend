package com.nathanlcr.MarketplaceDublin.service;

import com.nathanlcr.MarketplaceDublin.entity.User;
import com.nathanlcr.MarketplaceDublin.error.UserNotFoundException;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserDto;
import org.springframework.data.domain.Page;

public interface UserService {

    UserDto editUser(UserDto user);

    UserDto getUser(Integer id);

    Page<UserDto> getUsers();

    UserDto getUserAuthenticated();
}
