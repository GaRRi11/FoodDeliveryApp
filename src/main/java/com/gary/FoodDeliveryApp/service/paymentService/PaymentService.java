package com.gary.FoodDeliveryApp.service.paymentService;

import com.gary.FoodDeliveryApp.storage.model.payment.Payment;

import java.util.Optional;

public interface PaymentService {
    Payment setCreditCard(Payment creditCard);

    Optional<Payment> findById(Long id);

    void deleteById(Long id);
}
