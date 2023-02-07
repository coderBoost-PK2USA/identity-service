package com.coderboost.identityservice.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreateDto {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private long roleId;
}
