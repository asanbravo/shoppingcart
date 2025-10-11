package com.example.shoppingcart.valueobject;

public record ProductId(String value) {
    public ProductId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("ProductId cannot be null or blank");
        }
    }
    public static ProductId of(String value) {
        return new ProductId(value);
    }
}

