package com.ecommerce.ecommerce.model;

import lombok.Data;

@Data
public class ShoppingCart {

    private Long id;

    private Product product;

    private User user;
}
