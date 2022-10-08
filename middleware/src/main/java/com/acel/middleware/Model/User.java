package com.acel.middleware.Model;

import lombok.*;

import java.util.List;

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
