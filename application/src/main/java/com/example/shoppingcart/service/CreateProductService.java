package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.CreateProductCommand;
import com.example.shoppingcart.dto.ProductResponse;
import com.example.shoppingcart.usecase.CreateProductUseCase;

import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements CreateProductUseCase {

    @Override
    public ProductResponse execute(CreateProductCommand request) {
        return null;
    }
}