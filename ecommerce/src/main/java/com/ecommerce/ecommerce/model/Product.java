package com.ecommerce.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    
    @JsonManagedReference
    private List<Purchase> purchases;
}
