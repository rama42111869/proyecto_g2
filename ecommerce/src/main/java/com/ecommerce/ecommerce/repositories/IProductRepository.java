package com.ecommerce.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.DBModel.ProductJPA;

@Repository
public interface IProductRepository extends JpaRepository<ProductJPA, Long>{
    
}