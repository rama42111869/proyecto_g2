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
public class User {

    private Long id;
    
    private String name;
    
    private String surname;
    
    private String mail;

    @JsonManagedReference
    private List<Purchase> purchases;

}
