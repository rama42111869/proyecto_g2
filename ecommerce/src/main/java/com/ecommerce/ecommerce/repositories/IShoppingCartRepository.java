package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.DBModel.ShoppingCartJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShoppingCartRepository extends JpaRepository<ShoppingCartJPA, Long> {

//    List<ShoppingCartJPA> findAllByUserId(Long id);

    @Query(nativeQuery = true, value = "SELECT product FROM shopping_carts WHERE user_id=:userId")
    List<ShoppingCartJPA> findAllCartsByUser(@Param("userId") Long userId);

}
