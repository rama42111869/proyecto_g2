package com.ecommerce.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<Product> listAllProducts(){
        List<Product> allProducts = productService.getAllProducts();

        return new ResponseEntity<>(HttpStatus.OK, allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> listOneProduct(@PathVariable Long id){
        Product product = productService.getOneProduct(id);

        if(product != null){
            return new ResponseEntity<>(HttpStatus.OK, product);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND, id);
    }

    @PostMapping("/newProduct")
    public ResponseEntity<Product> createOneProduct(@RequestBody Product product){
        if(product != null){
            productService.createNewProduct(product);
            return new ResponseEntity<>(HttpStatus.CREATED, product);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST, product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Product> deleteOneProduct(@PathVariable Long id){
        Product product = productService.getOneProduct(id).get();

        if(product != null){
            productService.deleteOneProduct(id);
            return new ResponseEntity<>(HttpStatus.OK, product);
        }
        return null;
    }


}
