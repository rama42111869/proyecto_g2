package com.ecommerce.ecommerce.controllers;

import com.ecommerce.ecommerce.DBModel.ShoppingCartJPA;
import com.ecommerce.ecommerce.model.CartProductDTO;
import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shoppingCarts")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<CartProductDTO>> getAllProductsFromUser(@PathVariable Long userId){
        List<CartProductDTO> products = shoppingCartService.getAllItemsFromSpecificUser(userId);

        if(products != null){
            return ResponseEntity.ok().body(products);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/user/{userId}/product/{productId}")
    public ResponseEntity<Integer> addNewItemToWishList(@PathVariable Long userId, @PathVariable Long productId){
        Integer response = shoppingCartService.addProductShoppingCart(userId,productId);
        if(response == 0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteItemFromWishList(@PathVariable Long id){
        Integer response = shoppingCartService.deleteProductFromShoppingCart(id);

        if(response > 0 ){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
