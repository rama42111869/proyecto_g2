package com.acel.middleware.Service.Interface;

import com.acel.middleware.Model.Purchase;
import org.springframework.http.ResponseEntity;

public interface IPurchaseService {
    ResponseEntity<Integer> savePu(Purchase purchase);
    ResponseEntity<Integer> deletePu(Long id);
    ResponseEntity<Integer> updatePu(Purchase purchase);
    ResponseEntity<Purchase> readPu(Long id);
    ResponseEntity<Purchase[]> listAllPu();
}
