package com.ecommerce.ecommerce.DBModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "credit_cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String creditCardNumber;

    private int securityCode;

    private LocalDate expirationDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserJPA user;
}
