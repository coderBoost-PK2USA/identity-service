package com.coderboost.identityservice.controller;

import com.coderboost.identityservice.domain.dto.request.LoginRequest;
import com.coderboost.identityservice.domain.dto.request.RefreshTokenRequest;
import com.coderboost.identityservice.domain.dto.response.LoginResponse;
import com.coderboost.identityservice.service.AuthService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin(origins = {"http://localhost:3000"})
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ResponseStatus(OK)
    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }
}
