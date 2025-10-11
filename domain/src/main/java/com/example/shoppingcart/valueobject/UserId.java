package com.example.shoppingcart.valueobject;

public record UserId(String value) {

    public UserId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("UserId cannot be null or blank");
        }
    }
    public static UserId of(String value) {
        return new UserId(value);
    }
}

