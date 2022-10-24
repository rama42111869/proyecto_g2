package com.ecommerce.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ShoppingCart {

    private Long id;

    private Product product;

    @JsonIgnore
    private User user;
}
