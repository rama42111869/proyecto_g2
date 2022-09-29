package com.ecommerce.ecommerce.model;

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
    private Product product;
    private User user;
    private short amount;
    private Date date;

}
