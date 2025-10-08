package shoppingcart.usecase;

import shoppingcart.dto.CreateProductCommand;
import shoppingcart.dto.ProductResponse;

public interface CreateProductUseCase {

    ProductResponse execute(CreateProductCommand request);
}
