package com.gary.FoodDeliveryApp.service.authService;

import com.gary.FoodDeliveryApp.exceptions.CustomerNotFoundException;
import com.gary.FoodDeliveryApp.exceptions.InvalidEmailOrPasswordException;
import com.gary.FoodDeliveryApp.storage.model.customer.Customer;
import com.gary.FoodDeliveryApp.storage.repository.customer.CustomerRepository;
import com.gary.FoodDeliveryApp.exceptions.UsernameNotFoundException;
import com.gary.FoodDeliveryApp.web.dto.AuthenticationRequest;
import com.gary.FoodDeliveryApp.web.response.AuthenticationResponse;
import com.gary.FoodDeliveryApp.web.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final CustomerRepository customerRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(Customer customer) {
        customerRepository.save(customer);
        var jwtToken = jwtService.generateToken(customer);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (AuthenticationException ex) {
            throw new InvalidEmailOrPasswordException("Invalid email or password");
        }

        var customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException(request.getEmail()));
        var jwtToken = jwtService.generateToken(customer);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);
        authenticationResponse.setCustomer(customer);

        return authenticationResponse;
    }
}
