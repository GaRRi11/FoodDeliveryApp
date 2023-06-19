package com.gary.FoodDeliveryApp.service.customerService;

import com.gary.FoodDeliveryApp.storage.model.customer.Customer;
import com.gary.FoodDeliveryApp.storage.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public Customer save (Customer customer){
        return customerRepository.save(customer);
    }

    public Optional<Customer> findByEmail(String email){
        return customerRepository.findByEmail(email);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

}
