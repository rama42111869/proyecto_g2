package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.DBModel.ProductJPA;
import com.ecommerce.ecommerce.DBModel.ShoppingCartJPA;
import com.ecommerce.ecommerce.DBModel.UserJPA;
import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.repositories.IProductRepository;
import com.ecommerce.ecommerce.repositories.IShoppingCartRepository;
import com.ecommerce.ecommerce.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    private IShoppingCartRepository shoppingCartRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IProductRepository productRepository;

    public List<CartProductDTO> getAllItemsFromSpecificUser(Long userId){
        List<CartProductDTO> cartProductsDTO = new ArrayList<>();

        List<ShoppingCartJPA> sCartsFromUser = shoppingCartRepository.findByUserId(userId);

        sCartsFromUser.forEach(s -> {
            CartProductDTO cartProd = new CartProductDTO();
            cartProd.setProductId(s.getProduct().getId());
            cartProd.setProductName(s.getProduct().getName());
            cartProd.setProductDescription(s.getProduct().getDescription());
            cartProd.setProductImages(s.getProduct().getImages());
            cartProd.setProductPrice(s.getProduct().getPrice());
            cartProductsDTO.add(cartProd);
        });
        if(cartProductsDTO.size() > 0){
            return cartProductsDTO;
        }
        return null;
    }

    public ShoppingCartJPA addProductShoppingCart(Long userId, Long productId){
        UserJPA user = userRepository.findById(userId).get();
        ProductJPA product = productRepository.findById(productId).get();

        if(user != null && product != null){
            ShoppingCartJPA sCart = new ShoppingCartJPA();
            sCart.setUser(user);
            sCart.setProduct(product);
            shoppingCartRepository.save(sCart);
            return sCart;
        }
        return null;
    }

    public ShoppingCartJPA deleteProductFromShoppingCart(Long id){
        Optional<ShoppingCartJPA> sCart = shoppingCartRepository.findById(id);

        if(sCart.isPresent()){
            shoppingCartRepository.deleteById(id);
            return sCart.get();
        }
        return null;
    }
}
