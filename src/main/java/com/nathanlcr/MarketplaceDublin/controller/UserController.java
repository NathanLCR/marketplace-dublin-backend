package com.nathanlcr.MarketplaceDublin.controller;

import com.nathanlcr.MarketplaceDublin.entity.User;
import com.nathanlcr.MarketplaceDublin.error.UserNotFoundException;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.nathanlcr.MarketplaceDublin.service.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/v1/me")
    public ResponseEntity<UserDto> authenticatedUser() {
        return ResponseEntity.ok(userService.getUserAuthenticated());
    }

    @GetMapping("/v1")
    public ResponseEntity<Page<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PutMapping("/v1")
    public ResponseEntity<UserDto> editUser(UserDto userDto) {
        return ResponseEntity.ok(userService.editUser(userDto));
    }
}
