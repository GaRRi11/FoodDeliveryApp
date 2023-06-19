package com.gary.FoodDeliveryApp.service.customerService;

import com.gary.FoodDeliveryApp.storage.model.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer save (Customer customer);
    Optional<Customer> findByEmail(String email);
    List<Customer> getAllCustomers();
}
