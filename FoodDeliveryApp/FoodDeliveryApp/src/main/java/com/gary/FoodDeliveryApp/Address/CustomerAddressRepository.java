package com.gary.FoodDeliveryApp.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {

    //id movashoreoptional

    @Transactional
    @Modifying
    @Query("DELETE FROM CustomerAddress u WHERE u.id = ?1")
    void deleteCustomerAddressById(Long id); //inti voidad gadavakete
}
