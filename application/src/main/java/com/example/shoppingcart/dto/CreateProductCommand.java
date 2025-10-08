package com.example.shoppingcart.dto;

public record CreateProductCommand(String name, double price, int stock, String description) {
}
