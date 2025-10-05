package com.example.shoppingcart.model;

import java.util.UUID;

public record User (
        UUID id,
        String username,
        Email email
) {
}