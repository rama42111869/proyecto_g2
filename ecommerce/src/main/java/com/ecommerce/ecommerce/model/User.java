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
public class User {

    private Long id;
    private String name;
    private String surname;
    private String mail;

    private List<Purchase> purchases;


}
