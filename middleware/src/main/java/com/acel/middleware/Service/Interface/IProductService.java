package com.acel.middleware.Service.Interface;

import com.acel.middleware.Model.Product;
import org.springframework.http.ResponseEntity;

public interface IProductService {
    ResponseEntity<Integer> savePr(Product product);
    ResponseEntity<Integer> deletePr(Long id);
    ResponseEntity<Integer> updatePr(Product product);
    ResponseEntity<Product> readPr(Long id);
    ResponseEntity<Product[]> listAllPr();
}
