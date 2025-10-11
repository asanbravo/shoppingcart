package com.example.shoppingcart.output.persistence.mongo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class ProductDocument {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;
}


