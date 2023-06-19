package com.gary.FoodDeliveryApp.storage.repository.payment;

import com.gary.FoodDeliveryApp.storage.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {




    @Transactional
    @Modifying
    @Query("DELETE FROM CustomerCreditCard u WHERE u.id = ?1")
    void deleteCustomerCreditCardById(Long id);
}
