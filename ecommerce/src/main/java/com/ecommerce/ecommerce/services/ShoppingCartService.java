package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.DBModel.ShoppingCartJPA;
import com.ecommerce.ecommerce.model.Category;
import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.model.Purchase;
import com.ecommerce.ecommerce.repositories.IShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Product> getAllItemsFromSpecificUser(Long userId){
        List<ShoppingCartJPA> shoppingCartJPAS = shoppingCartRepository.findAllCartsByUser(userId);
        List<Product> products = new ArrayList<>();

        shoppingCartJPAS.forEach(sc -> {
            Product product = new Product();
            product.setId(sc.getProduct().getId());
            product.setName(sc.getProduct().getName());
            product.setBrand(sc.getProduct().getBrand());
            product.setPrice(sc.getProduct().getPrice());


            products.add(product);
        });

        if(products.isEmpty()){
            return null;
        }
        return products;
    }
}
