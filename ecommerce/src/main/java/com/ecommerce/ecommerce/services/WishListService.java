package com.ecommerce.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.DBModel.ProductJPA;
import com.ecommerce.ecommerce.DBModel.UserJPA;
import com.ecommerce.ecommerce.DBModel.WishListJPA;
import com.ecommerce.ecommerce.model.CartProductDTO;
import com.ecommerce.ecommerce.repositories.IProductRepository;
import com.ecommerce.ecommerce.repositories.IUserRepository;
import com.ecommerce.ecommerce.repositories.IWishListRepository;

@Service
public class WishListService {
    
    @Autowired
    private IWishListRepository wishListRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IProductRepository productRepository;

    public List<CartProductDTO> getProductsFromWishList(Long userId){
        List<WishListJPA> wishListJPA = wishListRepository.findByUserId(userId);
        List<CartProductDTO> products = new ArrayList<>();

        wishListJPA.forEach(i -> {
            CartProductDTO cProd = new CartProductDTO();
            cProd.setProductId(i.getProduct().getId());
            cProd.setProductName(i.getProduct().getName());
            cProd.setProductDescription(i.getProduct().getDescription());
            cProd.setProductImages(i.getProduct().getImages());
            cProd.setProductPrice(i.getProduct().getPrice());
            products.add(cProd);
        });

        return products;
    }

    public WishListJPA addItemToWishList(Long userId, Long prodId){
        UserJPA user = userRepository.findById(userId).get();
        ProductJPA product = productRepository.findById(prodId).get();

        if(user != null && product != null){
            WishListJPA wishList = new WishListJPA();
            wishList.setUser(user);
            wishList.setProduct(product);
            wishListRepository.save(wishList);
            return wishList;
        }
        return null;
    }

    public WishListJPA deleteItemFromWishList(Long id){
        try{
            Optional<WishListJPA> wList = wishListRepository.findById(id);
            if(wList != null){
                wishListRepository.deleteById(id);
                return wList.get();
            }
        }catch(Exception e){
            return null;
        }
        return null;
    }
}
