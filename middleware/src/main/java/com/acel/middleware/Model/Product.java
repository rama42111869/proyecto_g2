package com.acel.middleware.Model;

import lombok.*;

import java.util.List;

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

