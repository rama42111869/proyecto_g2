package com.acel.middleware.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
    private Long id;
    private String creditCardNumber;
    private int securityCode;
    private LocalDate expirationDate;
    private User user;
}
