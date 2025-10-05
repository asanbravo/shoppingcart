package com.example.shoppingcart.model;

import com.example.shoppingcart.valueobject.Email;
import com.example.shoppingcart.valueobject.UserId;

import java.time.LocalDateTime;
import java.util.Optional;

public record User (
        UserId id,
        Email email,
        String fullName,
        Optional<String> address,
        LocalDateTime createdAt
) {

    public User {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name cannot be null or blank");
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}