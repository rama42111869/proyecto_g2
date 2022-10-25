package com.acel.middleware.Model;
import lombok.Data;

@Data
public class CartProduct{
    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImages;
}
