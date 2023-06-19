package com.gary.FoodDeliveryApp.service.paymentService;

import com.gary.FoodDeliveryApp.storage.model.payment.Payment;
import com.gary.FoodDeliveryApp.storage.repository.payment.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment setCreditCard (Payment payment){
        return paymentRepository.save(payment);
    }

    public Optional<Payment> findById(Long id) {
        return paymentRepository.findById(id);
    }

    public void deleteById(Long id) {
        paymentRepository.deleteCustomerCreditCardById(id);
    }
}
