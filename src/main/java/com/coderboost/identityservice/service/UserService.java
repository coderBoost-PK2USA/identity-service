package com.coderboost.identityservice.service;

import com.coderboost.identityservice.domain.dto.request.ChangePasswordDto;
import com.coderboost.identityservice.domain.dto.request.UserCreateDto;

public interface UserService {

    void createUser(UserCreateDto userCreateDto);

    Boolean changePassword(long userId, ChangePasswordDto changePasswordDto);
}
