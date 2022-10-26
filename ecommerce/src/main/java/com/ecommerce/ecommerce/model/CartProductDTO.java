package com.ecommerce.ecommerce.model;

import lombok.Data;

@Data
public class CartProductDTO {

    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImages;
}
