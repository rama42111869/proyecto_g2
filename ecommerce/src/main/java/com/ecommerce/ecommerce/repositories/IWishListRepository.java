package com.ecommerce.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.DBModel.WishListJPA;

@Repository
public interface IWishListRepository extends JpaRepository<WishListJPA, Long> {
    List<WishListJPA> findByUserId(Long userId);    
}
