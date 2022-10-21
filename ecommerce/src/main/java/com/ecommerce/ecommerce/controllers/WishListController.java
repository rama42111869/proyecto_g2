package com.ecommerce.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.DBModel.WishListJPA;
import com.ecommerce.ecommerce.model.CartProductDTO;
import com.ecommerce.ecommerce.services.WishListService;

@RestController
@RequestMapping("/api/wishLists")
public class WishListController {
    
    @Autowired
    private WishListService wishListService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<CartProductDTO>> getProductsFromWish(@PathVariable Long userId){
        List<CartProductDTO> products = wishListService.getProductsFromWishList(userId);

        if(products.size() > 0){
            return ResponseEntity.ok().body(products);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/user/{userId}/product/{productId}")
    public ResponseEntity<Integer> postNewItemToWishList(@PathVariable Long userId, @PathVariable Long productId){
        WishListJPA wList = wishListService.addItemToWishList(userId, productId);

        if(wList != null){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteItemFromWishList(@PathVariable Long id){
        WishListJPA wList = wishListService.deleteItemFromWishList(id);

        if(wList != null){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
