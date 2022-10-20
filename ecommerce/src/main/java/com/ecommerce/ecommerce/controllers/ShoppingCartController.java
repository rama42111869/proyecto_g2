package com.ecommerce.ecommerce.controllers;

import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shoppingCarts")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Product>> getAllProductsFromUser(Long userId){
        List<Product> products = shoppingCartService.getAllItemsFromSpecificUser(userId);

        if(products != null){
            return ResponseEntity.ok().body(products);
        }
        return ResponseEntity.noContent().build();
    }
}
