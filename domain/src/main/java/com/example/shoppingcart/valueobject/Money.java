package com.example.shoppingcart.valueobject;

import java.math.BigDecimal;

public record Money(BigDecimal value, String currency) {


    public Money {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Money cannot be null or negative");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency cannot be null or blank");
        }

    }

    public Money(BigDecimal value) {
        this(value, "EUR");
    }
    public static Money of(BigDecimal value, String currency) {
        return new Money(value, currency);
    }
}

