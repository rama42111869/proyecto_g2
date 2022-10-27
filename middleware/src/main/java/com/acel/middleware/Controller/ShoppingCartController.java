package com.acel.middleware.Controller;

import com.acel.middleware.Model.CartProduct;
import com.acel.middleware.Service.Interface.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/middle/shoppingCarts")
public class ShoppingCartController {

    @Autowired
    private IShoppingCartService scs;

    @GetMapping("/{userId}")
    public ResponseEntity<CartProduct[]> getAllProductsFromUser(@PathVariable Long userId){
       return scs.listAllPrFromUs(userId);
    }

    @PostMapping("/user/{userId}/product/{productId}")
    public ResponseEntity<Integer> addNewItemToWishList(@PathVariable Long userId, @PathVariable Long productId){
        return scs.savePrToSc(userId,productId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteItemFromWishList(@PathVariable Long id){
        return scs.deletePrFromSc(id);
    }
}
