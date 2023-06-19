package com.gary.FoodDeliveryApp.web.dto;

import com.gary.FoodDeliveryApp.storage.model.customer.Customer;
import com.gary.FoodDeliveryApp.storage.model.customer.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerDTOMapper {

    private final PasswordEncoder passwordEncoder;

    public Customer fromDTO (CustomerRegistrationRequest customerRegistrationRequest) {
        return new Customer(
                customerRegistrationRequest.getFirstname(),
                customerRegistrationRequest.getLastname(),
                customerRegistrationRequest.getEmail(),
                passwordEncoder.encode(customerRegistrationRequest.getPassword()),
                customerRegistrationRequest.getRole()
        );
    }
}
