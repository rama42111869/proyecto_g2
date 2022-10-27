package com.acel.middleware.Controller;

import com.acel.middleware.Model.CartProduct;
import com.acel.middleware.Service.Interface.IWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/middle/wishLists")
public class WishListController {

    @Autowired
    private IWishListService wls;

    @GetMapping("/{userId}")
    public ResponseEntity<CartProduct[]> getProductsFromWish(@PathVariable Long userId){
        return wls.getPrFromWL(userId);
    }

    @PostMapping("/user/{userId}/product/{productId}")
    public ResponseEntity<Integer> postNewItemToWishList(@PathVariable Long userId, @PathVariable Long productId){
        return wls.savePrToWL(userId,productId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteItemFromWishList(@PathVariable Long id){
       return wls.deletePrFromWL(id);
    }
}
