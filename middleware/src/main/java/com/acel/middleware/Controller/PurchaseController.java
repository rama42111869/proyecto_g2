package com.acel.middleware.Controller;

import com.acel.middleware.Model.Purchase;
import com.acel.middleware.Service.Interface.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/middle/purchase")
@RestController
public class PurchaseController {
    @Autowired
    private IPurchaseService ip;

    @GetMapping()
    public ResponseEntity<Purchase[]> listAll(){
        return ip.listAllPu();
    }

    @GetMapping("/{idP}")
    public ResponseEntity<Purchase> get(@PathVariable("idP") Long idP){
        return ip.readPu(idP);
    }

    @PostMapping("/{idP}/{idU}")
    public ResponseEntity<Purchase> create(@PathVariable("idP") Long idP,@PathVariable("idU") Long idU,@RequestBody Purchase purchase){
        return ip.savePu(idP,idU,purchase);
    }
//    @PutMapping()
//    public ResponseEntity<Integer> update(@RequestBody Purchase purchase){
//        return ip.updatePu(purchase);
//    }
//
//    @DeleteMapping("/{idP}")
//    public ResponseEntity<Integer> delete(@PathVariable("idP") Long idP){
//        return ip.deletePu(idP);
//    }
}
