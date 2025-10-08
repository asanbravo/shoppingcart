package com.example.shoppingcart.repository;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.entity.Products;
import com.example.shoppingcart.valueobject.ProductId;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(ProductId productId);

    Product save(Product product);

    void delete(ProductId productId);

    boolean existsById(ProductId productId);

    boolean existsByName(String name);

    Products findAll();

    boolean hasStock(ProductId productId, int quantity);

    Products findByStockLessThan(int stockThreshold);

    Optional<Product> findByName(String name);
}
