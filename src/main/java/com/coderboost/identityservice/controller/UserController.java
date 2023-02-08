package com.coderboost.identityservice.controller;

import com.coderboost.identityservice.domain.dto.request.ChangePasswordDto;
import com.coderboost.identityservice.domain.dto.request.UserCreateDto;
import com.coderboost.identityservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.coderboost.identityservice.util.Util.getPrincipalId;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody UserCreateDto requestDto) {
        userService.createUser(requestDto);
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PostMapping("/password")
    public Boolean changePassword(
            Authentication authentication,
            @RequestBody ChangePasswordDto changePasswordDto
    ) {
        return userService.changePassword(getPrincipalId(authentication), changePasswordDto);
    }
}
