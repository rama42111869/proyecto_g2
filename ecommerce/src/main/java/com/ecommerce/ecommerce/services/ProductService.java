package com.ecommerce.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.DBModel.CategoryJPA;
import com.ecommerce.ecommerce.DBModel.ProductJPA;
import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.repositories.ICategoryRepository;
import com.ecommerce.ecommerce.repositories.IProductRepository;
import java.util.ArrayList;
import java.util.Random;

@Service
public class ProductService {
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private IProductRepository productRepository;
    
    @Autowired
    private ICategoryRepository categoryRepository;


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
        List<Product> allProducts = new ArrayList<>();
    
        for (ProductJPA productJPA : productRepository.findAll()) {
            allProducts.add(mapEntityToProduct(productJPA));
        }

        return allProducts;
    }

    public Product createNewProduct(Product product, Long categoryId){
        
        CategoryJPA categoryJPA = categoryRepository.findById(categoryId).get();
        
        if(categoryJPA != null){
            ProductJPA productJPA = mapProductToEntity(product);
            productJPA.setCategory(categoryJPA);
            productRepository.save(productJPA);
            return product;
        }   
        return null;
    }


    public Product updateProduct(Long id, Long categoryId, Product product){
        if(productRepository.existsById(id)){
            ProductJPA productToUpdate = productRepository.findById(id).get();
            
            CategoryJPA categoryToLink = categoryRepository.findById(categoryId).get();

           
            productToUpdate.setName(product.getName());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setImages(product.getImages());
            productToUpdate.setBrand(product.getBrand());
            
            if(categoryToLink != null){
                productToUpdate.setCategory(categoryToLink);
            }

            productRepository.save(productToUpdate);

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
    
    public List<Product> getProductsForCarrousel(){
        Random rand = new Random();
        
        List<Product> allProducts = getAllProducts();
        
        List<Long> idsList = new ArrayList<>();
        
        allProducts.forEach(prod -> {
            idsList.add(prod.getId());
        });
        
        List<Product> productsForCarroussel = new ArrayList<>();
        
        Long leftRange = 1L;
        Long rightRange = Long.valueOf(idsList.size());
        
        for(int i = 0; i<16; i++){
            Long randomLongId = leftRange + (long)(Math.random() * (rightRange - leftRange));
            int randomIdInt = randomLongId.intValue();
            
            Product prodToAdd =  allProducts.get(randomIdInt);
            
            productsForCarroussel.add(prodToAdd);
        }
        
        return productsForCarroussel;
    }


    /* MAPPERS */
    public Product mapEntityToProduct(ProductJPA productJPA){
        Product mapedProduct = modelMapper.map(productJPA, Product.class);
        return mapedProduct;
    }

    public ProductJPA mapProductToEntity(Product product){
                
        ProductJPA mapedJPA = new ProductJPA(
                product.getName(), 
                product.getDescription(), 
                product.getPrice(), 
                product.getImages(), 
                product.getBrand());
        
        return mapedJPA;
    }
}
