package com.nathanlcr.MarketplaceDublin.service;

import com.nathanlcr.MarketplaceDublin.entity.User;
import com.nathanlcr.MarketplaceDublin.error.UserNotFoundException;
import org.springframework.data.domain.Page;

public interface UserService {

    User createUser(User user);

    User editUser(User user);

    User getUser(Integer id);

    Page<User> getUsers();

    User getUserByEmail(String email) throws UserNotFoundException, UserNotFoundException;
}
