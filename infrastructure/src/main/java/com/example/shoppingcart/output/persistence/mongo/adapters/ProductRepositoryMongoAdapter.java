package com.example.shoppingcart.output.persistence.mongo.adapters;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.entity.Products;
import com.example.shoppingcart.output.persistence.mongo.mapper.ProductMongoMapper;
import com.example.shoppingcart.output.persistence.mongo.repository.ProductMongoRepository;
import com.example.shoppingcart.repository.ProductRepository;
import com.example.shoppingcart.valueobject.ProductId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductRepositoryMongoAdapter implements ProductRepository {

    private final ProductMongoRepository productMongoRepository;

    private final ProductMongoMapper mapper;

    public ProductRepositoryMongoAdapter(ProductMongoRepository productMongoRepository, ProductMongoMapper mapper) {
        this.productMongoRepository = productMongoRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return productMongoRepository
                .findById(mapper.toId(productId))
                .map(mapper::toEntity);
    }

    @Override
    public Product save(Product product) {
        return mapper.toEntity(
                productMongoRepository.save(mapper.toDocument(product))
        );
    }

    @Override
    public void delete(ProductId productId) {
        productMongoRepository.deleteById(mapper.toId(productId));
    }

    @Override
    public boolean existsById(ProductId productId) {
        return productMongoRepository.existsById(mapper.toId(productId));
    }


    @Override
    public Products findAll() {
        return new Products(
                productMongoRepository.findAll()
                        .stream()
                        .map(mapper::toEntity)
                        .toList()
        );
    }

    @Override
    public boolean hasStock(ProductId productId, int quantity) {
        return productMongoRepository.existsByIdAndStockGreaterThanEqual(
                mapper.toId(productId),
                quantity
        );
    }

    @Override
    public Products findByStockLessThan(int stockThreshold) {
        return new Products(
                productMongoRepository.findByStockLessThan(stockThreshold)
                        .stream()
                        .map(mapper::toEntity)
                        .toList()
        );
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productMongoRepository.findAll()
                .stream()
                .map(mapper::toEntity)
                .filter(product -> product.name().equalsIgnoreCase(name))
                .findFirst();
    }
}
