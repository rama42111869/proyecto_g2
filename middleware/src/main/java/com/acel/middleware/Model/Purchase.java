package com.acel.middleware.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    private Long id;

    @JsonIgnore
    private Product product;

    @JsonIgnore
    private User user;

    private int amount;

    private Date date;

    public Purchase(int amount){
        this.amount = amount;
    }

}