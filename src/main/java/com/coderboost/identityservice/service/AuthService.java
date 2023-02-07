package com.coderboost.identityservice.service;

import com.coderboost.identityservice.domain.dto.request.LoginRequest;
import com.coderboost.identityservice.domain.dto.request.RefreshTokenRequest;
import com.coderboost.identityservice.domain.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
