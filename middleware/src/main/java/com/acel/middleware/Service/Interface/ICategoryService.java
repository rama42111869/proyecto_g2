package com.acel.middleware.Service.Interface;

import com.acel.middleware.Model.Category;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {
    ResponseEntity<Category> saveC(Category category);
    ResponseEntity<Integer> deleteC(String name);
    ResponseEntity<Integer> updateC(String name,Category category);
    ResponseEntity<Category> readC(String name);
    ResponseEntity<Category[]> listAllC();
}
