package com.ecommerce.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.DBModel.UserJPA;

@Repository
public interface IUserRepository extends JpaRepository<UserJPA, Long>{
    
}
