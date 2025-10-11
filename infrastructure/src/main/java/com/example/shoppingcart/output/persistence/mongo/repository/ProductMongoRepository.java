package com.example.shoppingcart.output.persistence.mongo.repository;

import com.example.shoppingcart.output.persistence.mongo.document.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductMongoRepository extends MongoRepository<ProductDocument, String> {
    boolean existsByIdAndStockGreaterThanEqual(String id, int quantity);

    List<ProductDocument> findByStockLessThan(int stockThreshold);
}
