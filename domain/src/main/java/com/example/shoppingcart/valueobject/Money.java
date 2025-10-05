package com.example.shoppingcart.valueobject;

public record Money(Double value, String currency) {


    public Money {
        if ((value == null) || (value < 0.0)) {
            throw new IllegalArgumentException("Money cannot be null or negative");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency cannot be null or blank");
        }

    }

    public Money(Double value) {
        this(value, "EUR");
    }
    public static Money of(Double value, String currency) {
        return new Money(value, currency);
    }
}

