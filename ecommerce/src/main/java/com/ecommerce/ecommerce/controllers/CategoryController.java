package com.ecommerce.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.model.Category;
import com.ecommerce.ecommerce.services.CategoryService;


@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> listAllCategories(){
        List<Category> allCategories = categoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(allCategories);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Category> listOneCategory(@PathVariable String name){
        Category category = categoryService.getOneCategory(name);

        if(category != null){
            return ResponseEntity.status(HttpStatus.OK).body(category);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping()
    public ResponseEntity<Category> createOneCategory(@RequestBody Category category){
        if(category != null){
            categoryService.createNewCategory(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(category);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{name}")
    public ResponseEntity<Category> updateOneCategory(@PathVariable String name, @RequestBody Category category){
        if(category != null){
            categoryService.updateCategory(name, category);
            return ResponseEntity.status(HttpStatus.OK).body(category);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(category);
    }

}
