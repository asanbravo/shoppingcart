package shoppingcart.dto;

public record ProductResponse(  String id,
                                String name,
                                double price,
                                int stock,
                                String description) {
}
