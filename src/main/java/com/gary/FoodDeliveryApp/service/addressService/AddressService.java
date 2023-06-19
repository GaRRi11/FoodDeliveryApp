package com.gary.FoodDeliveryApp.service.addressService;

import com.gary.FoodDeliveryApp.storage.model.address.Address;

import java.util.Optional;

public interface AddressService {

    Address setAddress (Address address);
    Optional<Address> findById (Long id);

    void deleteById (Long id);
}
