package com.gary.FoodDeliveryApp.Customer;

import com.gary.FoodDeliveryApp.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


    @Query("SELECT s FROM Customer s WHERE s.email = ?1")
    Optional<Customer> findByEmail (String email);

}
