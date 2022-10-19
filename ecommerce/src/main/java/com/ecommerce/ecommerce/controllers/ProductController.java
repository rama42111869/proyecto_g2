package com.ecommerce.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> listAllProducts(){
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> listOneProduct(@PathVariable Long id){
        Product product = productService.getOneProduct(id);

        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @GetMapping("/carrouselProducts")
    public ResponseEntity<List<Product>> listProductsForCarroussel(){
        List<Product> productsForCarroussel = productService.getProductsForCarrousel();
        
        return ResponseEntity.status(HttpStatus.OK).body(productsForCarroussel);
    }

    @PostMapping("/{categoryId}")
    public ResponseEntity<Product> createOneProduct(@PathVariable Long categoryId, @RequestBody Product product){
        if(product != null){
            productService.createNewProduct(product, categoryId);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{id}/{categoryId}")
    public ResponseEntity<Product> updateOneProduct(@PathVariable Long id,@PathVariable Long categoryId, @RequestBody Product product){
        if(product != null){
            productService.updateProduct(id, categoryId, product);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteOneProduct(@PathVariable Long id){
        Product product = productService.getOneProduct(id);

        if(product != null){
            productService.deleteOneProduct(id);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return null;
    }


}
