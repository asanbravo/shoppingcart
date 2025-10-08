package shoppingcart.service;

import shoppingcart.dto.CreateProductCommand;
import shoppingcart.dto.ProductResponse;
import shoppingcart.usecase.CreateProductUseCase;

import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements CreateProductUseCase {

    @Override
    public ProductResponse execute(CreateProductCommand request) {
        return null;
    }
}