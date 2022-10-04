package com.ecommerce.ecommerce.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.DBModel.CategoryJPA;
import com.ecommerce.ecommerce.DBModel.ProductJPA;
import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.repositories.IProductRepository;

@Service
public class ProductService {
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private IProductRepository productRepository;


    public Product getOneProduct(Long id){
        Optional<ProductJPA> product = productRepository.findById(id);
        if(product.isPresent()){
            return mapEntityToProduct(product.get());
        }
        else {
            return null;
        }
    }

    public List<Product> getAllProducts(){
        List<Product> allProducts = new LinkedList<Product>();
    
        for (ProductJPA productJPA : productRepository.findAll()) {
            allProducts.add(mapEntityToProduct(productJPA));
        }

        return allProducts;
    }

    public Product createNewProduct(Product product){
        System.out.println("Producto Normal:"+product.getCategory().getName());
        ProductJPA productJPA = mapProductToEntity(product);
        System.out.println("Producto JPA:"+productJPA.getCategory().getName());;
        productRepository.save(productJPA);

        return product;
    }


    public Product updateProduct(Long id, Product product){
        if(productRepository.existsById(id)){
            ProductJPA productToUpdate = productRepository.findById(id).get();

            Product productModel = mapEntityToProduct(productToUpdate);

            productModel.setName(product.getName());
            productModel.setDescription(product.getDescription());
            productModel.setPrice(product.getPrice());
            productModel.setImages(product.getImages());
            productModel.setBrand(product.getBrand());

            productRepository.save(mapProductToEntity(productModel));

            return product;
        }
        return null;
    }

    public Product deleteOneProduct(Long id){
        Optional<ProductJPA> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.deleteById(id);
            Product productToReturn = mapEntityToProduct(product.get());
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
        ProductJPA mapedJPA = new ProductJPA(product.getId(), 
                                        product.getName(), 
                                        product.getDescription(), 
                                        product.getPrice(), 
                                        product.getImages(), 
                                        product.getBrand(), 
                                        new CategoryJPA(product.getCategory().getName()));
        return mapedJPA;
    }
}
