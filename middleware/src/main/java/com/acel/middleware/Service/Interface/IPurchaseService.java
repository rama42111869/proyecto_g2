package com.acel.middleware.Service.Interface;

import com.acel.middleware.Model.Purchase;
import org.springframework.http.ResponseEntity;

public interface IPurchaseService {
    ResponseEntity<Purchase[]> listAllPu();
    ResponseEntity<Purchase> readPu(Long idP);
    ResponseEntity<Purchase> savePu(Long idP,Long idU,Purchase purchase);
//    ResponseEntity<Integer> deletePu(Long id);
//    ResponseEntity<Integer> updatePu(Purchase purchase);
}
