package com.ecommerce.ecommerce.model;

import lombok.Data;

@Data
public class CartProductDTO {

    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImages;
}
