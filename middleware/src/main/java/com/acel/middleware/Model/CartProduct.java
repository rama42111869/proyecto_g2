package com.acel.middleware.Model;
import lombok.Data;

@Data
public class CartProduct{
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImages;
}
