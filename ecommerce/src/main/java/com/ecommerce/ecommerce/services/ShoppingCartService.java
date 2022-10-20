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
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IProductRepository productRepository;

    public List<CartProductDTO> getAllItemsFromSpecificUser(Long userId){
        List<ShoppingCartJPA> shoppingCartJPA = shoppingCartRepository.findAll();
        List<ShoppingCartJPA> shoppingCartJPAId = new ArrayList<>();
        List<CartProductDTO> cartProductsDTO = new ArrayList<>();

        shoppingCartJPA.forEach(s -> {
            Long user = s.getUser().getId();
            if(user == userId){
                shoppingCartJPAId.add(s);
            }
        });

        shoppingCartJPAId.forEach(s -> {
            CartProductDTO cartProd = new CartProductDTO();
            cartProd.setProductName(s.getProduct().getName());
            cartProd.setProductDescription(s.getProduct().getDescription());
            cartProd.setProductImages(s.getProduct().getImages());
            cartProd.setProductPrice(s.getProduct().getPrice());
            cartProductsDTO.add(cartProd);
        });

        return cartProductsDTO;
    }

    public Integer addProductShoppingCart(Long userId, Long productId){
        UserJPA user = userRepository.findById(userId).get();
        ProductJPA product = productRepository.findById(productId).get();

        if(user != null && product != null){
            ShoppingCartJPA sCart = new ShoppingCartJPA();
            sCart.setUser(user);
            sCart.setProduct(product);
            shoppingCartRepository.save(sCart);
            return 1;
        }
        return 0;
    }

    public Integer deleteProductFromShoppingCart(Long id){
        Optional<ShoppingCartJPA> sCart = shoppingCartRepository.findById(id);

        if(sCart.isPresent()){
            shoppingCartRepository.deleteById(id);
            return 1;
        }
        return 0;
    }
}
