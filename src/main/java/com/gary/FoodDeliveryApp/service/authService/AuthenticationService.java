package com.gary.FoodDeliveryApp.service.authService;

import com.gary.FoodDeliveryApp.storage.model.customer.Customer;
import com.gary.FoodDeliveryApp.web.response.AuthenticationResponse;
import com.gary.FoodDeliveryApp.web.dto.AuthenticationRequest;

public interface AuthenticationService {
    AuthenticationResponse register(Customer customer);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
