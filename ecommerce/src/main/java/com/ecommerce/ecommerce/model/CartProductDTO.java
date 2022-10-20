package com.ecommerce.ecommerce.model;

import lombok.Data;

import java.util.List;

@Data
public class CartProductDTO {

    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImages;
}
