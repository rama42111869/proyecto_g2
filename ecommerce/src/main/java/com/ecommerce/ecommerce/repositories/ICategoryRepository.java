package com.ecommerce.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.DBModel.CategoryJPA;
import java.util.Optional;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryJPA, Long>{
    
    public Optional<CategoryJPA> findByName(String name);
    
}
