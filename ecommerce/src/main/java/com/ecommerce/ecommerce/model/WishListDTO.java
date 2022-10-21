package com.ecommerce.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishListDTO {
    
    private Long id;

    @JsonIgnore
    private User user;

    private Product product;
}
