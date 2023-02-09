package com.coderboost.identityservice.domain.dto.response;

import com.coderboost.identityservice.contant.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
    private long userId;
    private String name;
    private String email;
    private String phoneNumber;
    private UserStatus userStatus;
}
