package com.ecommerce.ecommerce.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String images;
    private String brand;
    private Category category;
    
    private List<Purchase> purchases;
}
