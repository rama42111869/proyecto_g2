package com.acel.middleware.Controller;

import com.acel.middleware.Model.Purchase;
import com.acel.middleware.Service.Interface.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/middle/purchases")
public class PurchaseController {
    @Autowired
    private IPurchaseService ip;

    @GetMapping()
    public ResponseEntity<Purchase[]> listAll(){
        return ip.listAllPu();
    }

    @PostMapping()
    public ResponseEntity<Integer> create(@RequestBody Purchase purchase){
        return ip.savePu(purchase);
    }

    @GetMapping("/{idP}")
    public ResponseEntity<Purchase> get(@PathVariable("idP") Long idP){
        return ip.readPu(idP);
    }

    @PutMapping()
    public ResponseEntity<Integer> update(@RequestBody Purchase purchase){
        return ip.updatePu(purchase);
    }

    @DeleteMapping("/{idP}")
    public ResponseEntity<Integer> delete(@PathVariable("idP") Long idP){
        return ip.deletePu(idP);
    }
}
