package com.gary.FoodDeliveryApp.auth;

import com.gary.FoodDeliveryApp.Customer.Customer;
import com.gary.FoodDeliveryApp.Customer.CustomerRegistrationRequest;
import com.gary.FoodDeliveryApp.Customer.CustomerRepository;
import com.gary.FoodDeliveryApp.Customer.Role;
import com.gary.FoodDeliveryApp.Exceptions.UsernameNotFoundException;
import com.gary.FoodDeliveryApp.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(CustomerRegistrationRequest request) {
        var customer = Customer.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        customerRepository.save(customer);
        var jwtToken = jwtService.generateToken(customer);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) { //maps vamateb
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException(request.getEmail())); //amovige komidan
        var jwtToken = jwtService.generateToken(customer);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);
        authenticationResponse.setCustomer(customer);

        return authenticationResponse;
    }
}
