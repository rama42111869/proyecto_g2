package com.ecommerce.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class Purchase {

    private Long id;   
    

    @JsonBackReference
    private Product product;
    
    @JsonBackReference
    private User user;
    
    private int amount;
    
    private Date date;
    
    public Purchase(int amount){
        this.amount = amount;
    }

}
