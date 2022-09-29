package com.ecommerce.ecommerce.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.DBModel.CategoryJPA;
import com.ecommerce.ecommerce.DBModel.ProductJPA;
import com.ecommerce.ecommerce.DBModel.PurchaseJPA;
import com.ecommerce.ecommerce.DBModel.UserJPA;
import com.ecommerce.ecommerce.model.Category;
import com.ecommerce.ecommerce.model.Purchase;
import com.ecommerce.ecommerce.repositories.IPurchaseRepository;

@Service
public class PurchaseService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private IPurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchase() {
        List<Purchase> allPurchase = new LinkedList<Purchase>();
    
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
        PurchaseJPA mapedJPA = new PurchaseJPA(purchase.getId(), 
        purchase.getDate(), 
        new ProductJPA(purchase.getProduct().getName().getPrice()),
        new UserJPA(purchase.getUser().getMail().getName().getSurname()));
        return mapedJPA;
    }
    
}
