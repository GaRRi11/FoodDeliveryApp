package com.gary.FoodDeliveryApp.web.controller;

import com.gary.FoodDeliveryApp.exceptions.EmailAlreadyExistsException;
import com.gary.FoodDeliveryApp.service.authService.AuthenticationService;
import com.gary.FoodDeliveryApp.service.customerService.CustomerService;
import com.gary.FoodDeliveryApp.web.dto.CustomerDTOMapper;
import com.gary.FoodDeliveryApp.web.dto.CustomerRegistrationRequest;
import com.gary.FoodDeliveryApp.web.dto.AuthenticationRequest;
import com.gary.FoodDeliveryApp.web.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationService authenticationService;

    private final CustomerService customerService;

    private final CustomerDTOMapper customerDTOMapper;


    @PostMapping("/auth/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody CustomerRegistrationRequest request
    ){
        if (
                request.getFirstname() == null ||
                        request.getLastname() == null ||
                        request.getEmail() == null ||
                        request.getPassword() == null
        ){
            throw new NullPointerException("The request was malformed or missing required fields");
        }

        if (customerService.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("The specified username or email already exists");
        }
        return ResponseEntity.ok(authenticationService.register(customerDTOMapper.fromDTO(request)));

    }

    @PostMapping("/auth/authenticate")
    public AuthenticationResponse signIn(
            @RequestBody AuthenticationRequest request
    ){
        if (
                request.getEmail() == null ||
                        request.getPassword() == null
        ){
            throw new NullPointerException("The request was malformed or missing required fields");
        }
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);
        return authenticationResponse;
    }
}
