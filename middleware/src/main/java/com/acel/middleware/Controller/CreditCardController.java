package com.acel.middleware.Controller;

import com.acel.middleware.Model.CreditCard;
import com.acel.middleware.Service.Interface.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/middle/creditCards")
@RestController
public class CreditCardController {
    @Autowired
    private ICreditCardService ccs;

    @GetMapping("/{userId}")
    public ResponseEntity<CreditCard> getCreditCardByUser(@PathVariable Long userId){
        return ccs.readCCByUser(userId);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Integer> createNewCreditCard(@RequestBody CreditCard creditCard, @PathVariable Long userId){
        return ccs.saveCC(creditCard, userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteCreditCard(@PathVariable Long id){
        return ccs.deleteCC(id);
    }
}
