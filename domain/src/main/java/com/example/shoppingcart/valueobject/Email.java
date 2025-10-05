package com.example.shoppingcart.valueobject;

public record Email(String value) {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public Email(String value) {
        if (value == null || !value.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.value = value.toLowerCase().trim(); // en el canónico SÍ puedes asignar al campo
    }
    public static Email of(String value) {
        return new Email(value);
    }
}

