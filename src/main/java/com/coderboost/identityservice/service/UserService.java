package com.coderboost.identityservice.service;

import com.coderboost.identityservice.domain.dto.request.ChangePasswordDto;
import com.coderboost.identityservice.domain.dto.request.UserCreateDto;
import com.coderboost.identityservice.domain.dto.response.UserDetailsDto;

public interface UserService {

    UserDetailsDto createUser(UserCreateDto userCreateDto);

    UserDetailsDto getUserById(long userId);

    UserDetailsDto getUserByEmail(String email);

    Boolean changePassword(long userId, ChangePasswordDto changePasswordDto);
}
