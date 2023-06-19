package com.gary.FoodDeliveryApp.storage.repository.address;

import com.gary.FoodDeliveryApp.storage.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface AddressRepository extends JpaRepository<Address, Long> {

    //id movashoreoptional

    @Transactional
    @Modifying
    @Query("DELETE FROM CustomerAddress u WHERE u.id = ?1")
    void deleteCustomerAddressById(Long id);
}
