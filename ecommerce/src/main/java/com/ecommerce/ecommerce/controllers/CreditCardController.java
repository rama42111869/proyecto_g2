package com.ecommerce.ecommerce.controllers;

import com.ecommerce.ecommerce.model.CreditCard;
import com.ecommerce.ecommerce.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/creditCards")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping("/{userId}")
    public ResponseEntity<CreditCard> getCreditCardByUser(@PathVariable Long userId){
        CreditCard creditCard = creditCardService.getCreditCardByUser(userId);

        if(creditCard != null){
            return ResponseEntity.ok().body(creditCard);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Integer> createNewCreditCard(@RequestBody CreditCard creditCard, @PathVariable Long userId){
        Integer response = creditCardService.createN1ewCreditCard(creditCard, userId);

        if(response != 0){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteCreditCard(@PathVariable Long id){
        Integer response = creditCardService.deleteOneCreditCard(id);

        if(response != 0){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
