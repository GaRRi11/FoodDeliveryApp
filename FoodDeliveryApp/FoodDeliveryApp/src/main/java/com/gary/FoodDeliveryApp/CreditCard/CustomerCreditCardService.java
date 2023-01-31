package com.gary.FoodDeliveryApp.CreditCard;

import com.gary.FoodDeliveryApp.Customer.Customer;
import com.gary.FoodDeliveryApp.Exceptions.CreditCardDoesNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCreditCardService {

    private final CustomerCreditCardRepository customerCreditCardRepository;

    public CustomerCreditCard setCreditCard(CustomerCreditCardRequest creditCardRequest,
                              Customer customer){
        CustomerCreditCard customerCreditCard = new CustomerCreditCard(
                creditCardRequest.getCardNumber(),
                creditCardRequest.getExpirationDate(),
                creditCardRequest.getCcv(),
                creditCardRequest.getCardHolderName(),
                customer
        );
        customerCreditCardRepository.save(customerCreditCard);
        return customerCreditCard;

    }

    public CustomerCreditCard findById(Long id) {
        return customerCreditCardRepository.findById(id).orElseThrow(
                () -> new CreditCardDoesNotExistException(id)
        );
    }

    public void deleteById(Long id) {
        customerCreditCardRepository.deleteCustomerCreditCardById(id);
    }
}
