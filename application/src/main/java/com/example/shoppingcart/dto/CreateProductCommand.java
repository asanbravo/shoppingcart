package com.example.shoppingcart.dto;

import java.math.BigDecimal;

public record CreateProductCommand(String name, BigDecimal price, int stock, String description) {
}
