package com.gary.FoodDeliveryApp.auth;

import com.gary.FoodDeliveryApp.Customer.Customer;
import com.gary.FoodDeliveryApp.Customer.CustomerRegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authi") //i
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    private Customer customer;

    @PostMapping("/register")
    public ResponseEntity <AuthenticationResponse> register(
            @RequestBody CustomerRegistrationRequest request
    ){
        return ResponseEntity.ok(service.register(request));

    }

    @PostMapping("/authenticate")
    public AuthenticationResponse signIn(
            @RequestBody AuthenticationRequest request
    ){

        AuthenticationResponse authenticationResponse = service.authenticate(request);
        this.customer = authenticationResponse.getCustomer();
        return authenticationResponse;
    }
}
