package com.coderboost.identityservice.mapper;

import com.coderboost.identityservice.domain.dto.response.UserDetailsDto;
import com.coderboost.identityservice.domain.entity.User;

public class UserMapper {

    public static UserDetailsDto toUserDetailsDto(User user) {
        return new UserDetailsDto(user.getId(), user.getName(), user.getEmail(), user.getPhoneNumber(), user.getUserStatus());
    }

}
