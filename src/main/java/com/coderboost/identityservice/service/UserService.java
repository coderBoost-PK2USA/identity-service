package com.coderboost.identityservice.service;

import com.coderboost.identityservice.domain.dto.request.ChangePasswordDto;
import com.coderboost.identityservice.domain.dto.request.UserCreateDto;
import com.coderboost.identityservice.domain.dto.response.UserDetailsDto;

public interface UserService {

    void createUser(UserCreateDto userCreateDto);

    UserDetailsDto getUserById(long userId);

    Boolean changePassword(long userId, ChangePasswordDto changePasswordDto);
}
