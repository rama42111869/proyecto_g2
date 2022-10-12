package com.acel.middleware.Service.Interface;

import com.acel.middleware.Model.Product;
import org.springframework.http.ResponseEntity;

public interface IProductService {
    ResponseEntity<Product[]> listAllPr();
    ResponseEntity<Product[]> listPrCarrousel();
    ResponseEntity<Product> readPr(Long idP);
    ResponseEntity<Product> savePr(Long idC,Product product);
    ResponseEntity<Product> updatePr(Long idP,Long idC,Product product);
    ResponseEntity<Integer> deletePr(Long idP);
}
