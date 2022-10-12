package com.acel.middleware.Controller;

import com.acel.middleware.Model.Category;
import com.acel.middleware.Service.Interface.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/middle/category")
@RestController
public class CategoryController {
    @Autowired
    private ICategoryService iC;

    @GetMapping()
    public ResponseEntity<Category[]> listAll(){
        return iC.listAllC();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Category> getBy(@PathVariable("name") String idC){
        return iC.readC(idC);
    }

    @PostMapping()
    public ResponseEntity<Category> create(@RequestBody Category category){
        return iC.saveC(category);
    }

    @PutMapping("/{name}")
    public ResponseEntity<Category> update(@PathVariable("name") String name,@RequestBody Category category){
        return iC.updateC(name,category);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Integer> delete(@PathVariable("name") String name){
        return iC.deleteC(name);
    }
}
