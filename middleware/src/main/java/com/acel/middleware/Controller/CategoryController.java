package com.acel.middleware.Controller;

import com.acel.middleware.Model.Category;
import com.acel.middleware.Service.Interface.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/middle/category")
public class CategoryController {
    @Autowired
    private ICategoryService iC;

    @GetMapping()
    public ResponseEntity<Category[]> listAll(){
        return iC.listAllC();
    }

    @PostMapping()
    public ResponseEntity<Integer> create(@RequestBody Category category){
        return iC.saveC(category);
    }

    @GetMapping("/{idC}")
    public ResponseEntity<Category> get(@PathVariable("idC") Long idC){
        return iC.readC(idC);
    }

    @PutMapping()
    public ResponseEntity<Integer> update(@RequestBody Category category){
        return iC.updateC(category);
    }

    @DeleteMapping("/{idC}")
    public ResponseEntity<Integer> delete(@PathVariable("idC") Long idC){
        return iC.deleteC(idC);
    }
}
