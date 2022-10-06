package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.DBModel.ProductJPA;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.DBModel.PurchaseJPA;
import com.ecommerce.ecommerce.DBModel.UserJPA;
import com.ecommerce.ecommerce.model.Purchase;
import com.ecommerce.ecommerce.repositories.IProductRepository;
import com.ecommerce.ecommerce.repositories.IPurchaseRepository;
import com.ecommerce.ecommerce.repositories.IUserRepository;
import java.util.Date;

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
    
    @Autowired 
    private IProductRepository productRepository;
    
    @Autowired
    private IUserRepository userRepository;

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

    public Purchase createNewPurchase(Purchase purchase, Long productId, Long userId) {
        if(purchase != null){
            
            ProductJPA product = productRepository.findById(productId).get();
            Optional<UserJPA> user = userRepository.findById(userId);
            
            PurchaseJPA purchaseJPA = new PurchaseJPA(new Date(System.currentTimeMillis()), purchase.getAmount(), product, user.get());

            

            purchaseRepository.save(purchaseJPA);

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
        
        ProductJPA product = productRepository.findById(purchase.getProduct().getId()).get();
        
        Optional<UserJPA> user = userRepository.findById(purchase.getUser().getId());
        
        
        PurchaseJPA purchaseJPA;
        purchaseJPA = new PurchaseJPA(new Date(System.currentTimeMillis()), purchase.getAmount(), product, user.get());
        
           return purchaseJPA;
    }
}
