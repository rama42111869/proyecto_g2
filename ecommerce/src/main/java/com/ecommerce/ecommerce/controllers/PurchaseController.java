package com.ecommerce.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.model.Purchase;
import com.ecommerce.ecommerce.services.PurchaseService;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping()
    public ResponseEntity<List<Purchase>> listAllPurchase(){
        List<Purchase> allPurchase = purchaseService.getAllPurchase();
        return ResponseEntity.status(HttpStatus.OK).body(allPurchase);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> listOnePurchase(@PathVariable Long id){
        Purchase purchase = purchaseService.getOnePurchase(id);

        if(purchase != null){
            return ResponseEntity.status(HttpStatus.OK).body(purchase);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Purchase>> listOnePurchaseByUser(@PathVariable Long userId){
        List<Purchase> purchase = purchaseService.getPurchaseByUserId(userId);

        if(!purchase.isEmpty()){
            return ResponseEntity.ok().body(purchase);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{productId}/{userId}")
    public ResponseEntity<Purchase> createOnePurchase(@PathVariable Long productId, @PathVariable Long userId, @RequestBody Purchase purchase){
        if(purchase != null){
            purchaseService.createNewPurchase(purchase, productId, userId);
            return ResponseEntity.status(HttpStatus.CREATED).body(purchase);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
