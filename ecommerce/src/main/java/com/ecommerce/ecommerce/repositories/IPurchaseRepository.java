package com.ecommerce.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.DBModel.PurchaseJPA;

@Repository
public interface IPurchaseRepository extends JpaRepository<PurchaseJPA, Long> {

}
