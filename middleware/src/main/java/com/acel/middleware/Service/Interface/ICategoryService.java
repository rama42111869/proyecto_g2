package com.acel.middleware.Service.Interface;

import com.acel.middleware.Model.Category;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {
    ResponseEntity<Integer> saveC(Category category);
    ResponseEntity<Integer> deleteC(Long id);
    ResponseEntity<Integer> updateC(Category category);
    ResponseEntity<Category> readC(Long id);
    ResponseEntity<Category[]> listAllC();
}
