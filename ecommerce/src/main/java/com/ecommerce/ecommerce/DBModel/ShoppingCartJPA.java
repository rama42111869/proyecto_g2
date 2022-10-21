package com.ecommerce.ecommerce.DBModel;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "shopping_carts")
@Data
public class ShoppingCartJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name ="product_id")
    private ProductJPA product;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserJPA user;
}
