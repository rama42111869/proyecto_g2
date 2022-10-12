package com.acel.middleware.Controller;

import com.acel.middleware.Model.Product;
import com.acel.middleware.Service.Interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/middle/products")
@RestController
public class    ProductController {
    @Autowired
    private IProductService ip;

    @GetMapping()
    public ResponseEntity<Product[]> listAll(){
        return ip.listAllPr();
    }

    @GetMapping("/{idP}")
    public ResponseEntity<Product> get(@PathVariable("idP") Long idP){
        return ip.readPr(idP);
    }

    @PostMapping("/{idC}")
    public ResponseEntity<Product> create(@PathVariable("idC") Long idC,@RequestBody Product product){
        return ip.savePr(idC,product);
    }

    @PutMapping("/{idP}/{idC}")
    public ResponseEntity<Product> update(@PathVariable("idP") Long idP,@PathVariable("idC") Long idC,@RequestBody Product user){
        return ip.updatePr(idP,idC,user);
    }

    @DeleteMapping("/{idP}")
    public ResponseEntity<Integer> delete(@PathVariable("idP") Long idP){
        return ip.deletePr(idP);
    }
}