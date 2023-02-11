package com.coderboost.identityservice.controller;

import com.coderboost.identityservice.domain.dto.request.ChangePasswordDto;
import com.coderboost.identityservice.domain.dto.request.UserCreateDto;
import com.coderboost.identityservice.domain.dto.response.UserDetailsDto;
import com.coderboost.identityservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.coderboost.identityservice.util.Util.getPrincipalId;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDetailsDto createUser(@RequestBody UserCreateDto requestDto) {
       return userService.createUser(requestDto);
    }

    @GetMapping("{id}")
    public UserDetailsDto getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public UserDetailsDto getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
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
