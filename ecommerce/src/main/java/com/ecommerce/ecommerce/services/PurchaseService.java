package com.ecommerce.ecommerce.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.DBModel.PurchaseJPA;
import com.ecommerce.ecommerce.model.Purchase;
import com.ecommerce.ecommerce.repositories.IPurchaseRepository;

@Service
public class PurchaseService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private IPurchaseRepository purchaseRepository;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserService userService;

    public List<Purchase> getAllPurchase() {
        List<Purchase> allPurchase = new LinkedList<>();
    
        for (PurchaseJPA pruchaseJPA : purchaseRepository.findAll()) {
            allPurchase.add(mapEntityToPurchase(pruchaseJPA));
        }

        return allPurchase;
    }

    public Purchase getOnePurchase(Long id) {
        Optional<PurchaseJPA> purchase = purchaseRepository.findById(id);
        if(purchase.isPresent()){
            return mapEntityToPurchase(purchase.get());
        }
        else {
            return null;
        }
    }

    public Purchase createNewPurchase(Purchase purchase) {
        if(purchase != null){
            PurchaseJPA purchaseJPA = mapPurchaseToEntity(purchase);

            purchaseRepository.save(purchaseJPA);

            return purchase;
        }
        return null;
    }

    public Purchase updatePurchase(Long id, Purchase purchase) {
        if(purchaseRepository.existsById(id)){
            PurchaseJPA purchaseToUpdate = purchaseRepository.findById(id).get();

            Purchase purchaseModel = mapEntityToPurchase(purchaseToUpdate);

            purchaseModel.setDate(purchase.getDate());

            purchaseRepository.save(mapPurchaseToEntity(purchaseModel));

            return purchase;
        }
        return null;
    }
    
    /* MAPPERS */
    public Purchase mapEntityToPurchase(PurchaseJPA purchaseJPA){
        Purchase mapedPurchase = modelMapper.map(purchaseJPA, Purchase.class);
        return mapedPurchase;
    }

    public PurchaseJPA mapPurchaseToEntity(Purchase purchase){
        PurchaseJPA purchaseJPA = new PurchaseJPA(
                purchase.getId(),
                productService.mapProductToEntity(purchase.getProduct()),
                userService.mapUserToEntity(purchase.getUser()),
                purchase.getAmount(),
                purchase.getDate()            
        );
           return purchaseJPA;

    }
    
}
