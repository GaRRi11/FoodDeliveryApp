package com.gary.FoodDeliveryApp.CreditCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerCreditCardRepository extends JpaRepository<CustomerCreditCard,Long> {




    @Transactional
    @Modifying
    @Query("DELETE FROM CustomerCreditCard u WHERE u.id = ?1")
    void deleteCustomerCreditCardById(Long id);
}
