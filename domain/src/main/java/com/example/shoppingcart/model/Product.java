package com.example.shoppingcart.model;

import com.example.shoppingcart.valueobject.Money;
import com.example.shoppingcart.valueobject.ProductId;

import java.util.Optional;

public record Product(
        ProductId id,
        String name,
        Optional<String> description,
        Money price,
        int stock
) {

    public Product {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }

    public static Product of(ProductId id, String name, Optional<String> description, Money money, int stock) {
        return new Product(id, name, description, money, stock);
    }
}