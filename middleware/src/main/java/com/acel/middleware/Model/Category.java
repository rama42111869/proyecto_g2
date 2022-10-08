package com.acel.middleware.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long id;
    private String name;
    private String sizes;

    @JsonIgnore
    private List<Product> products;

    public Category(String name){
        this.name = name;
    }

    public Category(String name, String sizes){
        this.name = name;
        this.sizes = sizes;
    }
}