package com.example.shoppingcart.output.persistence.mongo.mapper;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.output.persistence.mongo.document.ProductDocument;
import com.example.shoppingcart.valueobject.ProductId;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProductMongoMapper {

    Product toEntity(ProductDocument productDocument);

    ProductDocument toDocument(Product product);

    default String toId(ProductId id) {
        return id == null ? null : id.value();
    }
}
