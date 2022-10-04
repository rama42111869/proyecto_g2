package com.ecommerce.ecommerce.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class User {

    private String name;
    private String surname;
    private String mail;

    private Set<Purchase> purchases;

}
