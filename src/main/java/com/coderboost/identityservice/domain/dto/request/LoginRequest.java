package com.coderboost.identityservice.domain.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest {
    private String email;
    private String password;
}
