package com.example.shoppingcart.dto;

import java.math.BigDecimal;

public record ProductResponse(
        String id,
        String name,
        BigDecimal price,
        int stock,
        String description
) {
}
