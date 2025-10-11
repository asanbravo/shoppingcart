package com.example.shoppingcart.entity;

import com.example.shoppingcart.valueobject.Money;
import com.example.shoppingcart.valueobject.ProductId;

import org.jetbrains.annotations.Nullable;


public record Product(
        ProductId id,
        String name,
        @Nullable String description,
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

    public static Product of(ProductId id, String name, @Nullable String description, Money money, int stock) {
        return new Product(id, name, description, money, stock);
    }

    public Product withStock(int newStock) {
        if (newStock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }

        if (this.stock == newStock) {
            return this;
        }

        return new Product(
                this.id,
                this.name,
                this.description,
                this.price,
                newStock
        );
    }
}