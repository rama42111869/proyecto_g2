package com.acel.middleware.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private float price;
    private String images;
    private String brand;
}
