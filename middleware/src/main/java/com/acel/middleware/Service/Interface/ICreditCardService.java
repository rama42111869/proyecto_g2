package com.acel.middleware.Service.Interface;

import com.acel.middleware.Model.CreditCard;
import org.springframework.http.ResponseEntity;

public interface ICreditCardService {
    ResponseEntity<CreditCard> readCCByUser(Long userId);
    ResponseEntity<Integer> saveCC(CreditCard creditCard,Long userId);
    ResponseEntity<Integer> deleteCC(Long IdCC);
}