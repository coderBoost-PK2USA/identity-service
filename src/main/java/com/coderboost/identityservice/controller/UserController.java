package com.coderboost.identityservice.controller;

import com.coderboost.identityservice.domain.dto.request.UserCreateDto;
import com.coderboost.identityservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//  TODO: Remove after adding role dependant API
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String test(){
        return "Success";
    }
}
