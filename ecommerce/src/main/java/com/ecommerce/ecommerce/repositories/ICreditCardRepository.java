package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.DBModel.CreditCardJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditCardRepository extends JpaRepository<CreditCardJPA, Long> {

    CreditCardJPA findByUserId(Long id);
}
