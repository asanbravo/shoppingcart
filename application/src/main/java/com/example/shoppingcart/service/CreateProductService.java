package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.CreateProductCommand;
import com.example.shoppingcart.dto.ProductResponse;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.exception.ProductAlreadyExistsException;
import com.example.shoppingcart.mapper.ProductMapper;
import com.example.shoppingcart.repository.ProductRepository;
import com.example.shoppingcart.usecase.CreateProductUseCase;
import com.example.shoppingcart.valueobject.ProductId;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateProductService implements CreateProductUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public CreateProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse execute(CreateProductCommand request) {

        productRepository.findByName(request.name())
                .ifPresent(existingProduct -> {
                    throw new ProductAlreadyExistsException(request.name());
                });

        ProductId productId = ProductId.of(UUID.randomUUID().toString());

        Product product = productMapper.toDomainWithId(request, productId);

        Product savedProduct = productRepository.save(product);

        return productMapper.toResponse(savedProduct);
    }
}