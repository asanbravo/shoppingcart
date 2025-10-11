package com.example.shoppingcart.mapper;

import com.example.shoppingcart.dto.CreateProductCommand;
import com.example.shoppingcart.dto.ProductResponse;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.valueobject.Money;
import com.example.shoppingcart.valueobject.ProductId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper(componentModel = "spring", imports = {BigDecimal.class})
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "description", source = "description")
    Product toDomain(CreateProductCommand command);

    default Product toDomainWithId(CreateProductCommand command, ProductId id) {
        return Product.of(
                id,
                command.name(),
                command.description(),
                new Money(command.price()),
                command.stock()
        );
    }

    ProductResponse toResponse(Product product);


    // BigDecimal -> Money
    default Money map(BigDecimal price) {
        return new Money(price);
    }

    default String map(ProductId id) {
        return id == null ? null : id.value();
    }

    default BigDecimal map(Money money) {
        return money == null ? BigDecimal.ZERO : money.value();
    }

}
