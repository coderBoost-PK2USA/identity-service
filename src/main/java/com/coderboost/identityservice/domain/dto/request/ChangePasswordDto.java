package com.coderboost.identityservice.domain.dto.request;

import java.util.Objects;

public record ChangePasswordDto(String password, String passwordConfirmation) {
    public void validatePasswordMatch() {
        if (!Objects.equals(password, passwordConfirmation)) {
            throw new RuntimeException("Confirmation Password Mismatched");
        }
    }
}
