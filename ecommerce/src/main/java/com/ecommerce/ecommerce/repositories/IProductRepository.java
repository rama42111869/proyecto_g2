package com.ecommerce.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.DBModel.ProductJPA;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface IProductRepository extends JpaRepository<ProductJPA, Long>{

    List<ProductJPA> findByNameContainingOrDescriptionContainingOrBrandContainingOrCategoryNameContaining(
            String name,
            String description,
            String brand,
            String category);

    List<ProductJPA> findByCategoryName(String category);

}
