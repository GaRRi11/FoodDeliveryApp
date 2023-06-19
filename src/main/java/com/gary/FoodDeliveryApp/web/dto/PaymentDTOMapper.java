package com.gary.FoodDeliveryApp.web.dto;

import com.gary.FoodDeliveryApp.storage.model.payment.Payment;
import com.gary.FoodDeliveryApp.storage.model.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class PaymentDTOMapper {
    public Payment fromDTO (PaymentRequest creditCardRequest, Customer customer){
        return new Payment(
                creditCardRequest.getCardNumber(),
                creditCardRequest.getExpirationDate(),
                creditCardRequest.getCcv(),
                creditCardRequest.getCardHolderName(),
                customer
        );
    }
}
