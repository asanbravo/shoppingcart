package com.example.shoppingcart.usecase;

import com.example.shoppingcart.dto.CreateProductCommand;
import com.example.shoppingcart.dto.ProductResponse;

public interface CreateProductUseCase {

    ProductResponse execute(CreateProductCommand request);
}
