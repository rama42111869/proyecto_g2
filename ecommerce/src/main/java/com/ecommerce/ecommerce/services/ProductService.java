package com.ecommerce.ecommerce.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.repositories.IProductRepository;

@Service
public class ProductService {
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private IProductRepository productRepository;


    public Product getOneProduct(Long id){
        if(productRepository.existsById(id)){
            // Product product = modelMapper.map(productRepository.findById(id), Product.class);
            Product product = mapEntityToProduct(productRepository.findById(id));
            return product;
        }
        return null;
    }

    public List<Product> getAllProducts(){
        // List<Product> allProducts = modelMapper.map(productRepository.findAll(), Product.class);

        List<Product> allProducts = mapEntityToProduct(productRepository.findAll());

        return allProducts;
    }

    public Product createNewProduct(Product product){
        // ProductJPA productJPA = mapProductToEntity(product);

        ProdJPA productJPA = mapProductToEntity(product);

        productRepository.save(productJPA);

        return product;
    }


    public Product updateProduct(Long id, Product product){
        if(productRepository.existsById(id)){
            ProductJPA productToUpdate = productRepository.findById(id).get();

            /*
             * Actualizar campos del productToUpdate
             */

            productRepository.save(productToUpdate);

            return product;
        }
        return null;
    }

    public Product deleteOneProduct(Long id){
        if(productRepository.existsById(id)){
            ProductJPA product = productRepository.findById(id).get();

            // Product productToReturn = modelMapper.map(product, Product.class);
            Product productToReturn = mapEntityToProduct(product);

            productRepository.deleteById(id);

            return productToReturn;
        }
        return null;
    }


    /* MAPPERS */

    public Product mapEntityToProduct(ProductJPA productJPA){
        Product mapedProduct = modelMapper.map(productJPA, Product.class);
        return mapedProduct;
    }

    public ProductJPA mapProductToEntity(Product product){
        ProductJPA mapedJPA = modelMapper.map(Product, ProductJPA.class);
        return mapedJPA;
    }
}
