package com.coderboost.identityservice.service.impl;

import com.coderboost.identityservice.domain.dto.request.ChangePasswordDto;
import com.coderboost.identityservice.domain.dto.request.UserCreateDto;
import com.coderboost.identityservice.domain.dto.response.UserDetailsDto;
import com.coderboost.identityservice.domain.entity.Role;
import com.coderboost.identityservice.domain.entity.User;
import com.coderboost.identityservice.repository.RoleRepository;
import com.coderboost.identityservice.repository.UserRepository;
import com.coderboost.identityservice.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

import static com.coderboost.identityservice.contant.UserStatus.INACTIVE;
import static com.coderboost.identityservice.util.Util.getEncodedPassword;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void createUser(UserCreateDto userCreateDto) {
        Optional<User> user = userRepository.findByEmail(userCreateDto.getEmail());
        Role role = roleRepository.findById(userCreateDto.getRoleId()).orElseThrow();

        if (user.isEmpty()) {
            User newUser = new User(
                    0,
                    userCreateDto.getName(),
                    userCreateDto.getEmail(),
                    getEncodedPassword(userCreateDto.getPassword()),
                    userCreateDto.getPhoneNumber(),
                    INACTIVE,
                    role,
                    Instant.now(),
                    Instant.now()
            );
            userRepository.save(newUser);
        } else {
            throw new RuntimeException("Username already exists!");
        }
    }

    @Override
    public UserDetailsDto getUserById(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Username doesn't exist!"));
        return new UserDetailsDto(user.getName(), user.getEmail(), user.getPhoneNumber(), user.getUserStatus());
    }

    @Override
    public Boolean changePassword(long userId, ChangePasswordDto changePasswordDto) {
        changePasswordDto.validatePasswordMatch();
        return userRepository.findById(userId)
                .map(user -> {
                    String encryptedPassword = getEncodedPassword(changePasswordDto.password());
                    User.builder().password(encryptedPassword).build();
                    userRepository.save(user);
                    return true;
                })
                .orElseThrow(() -> new RuntimeException("User Not Found!"));
    }
}
