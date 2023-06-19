package com.gary.FoodDeliveryApp.service.addressService;

import com.gary.FoodDeliveryApp.storage.model.address.Address;
import com.gary.FoodDeliveryApp.storage.repository.address.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;


    public Address setAddress (Address address){
        return addressRepository.save(address);
    }



    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    public void deleteById(Long id){
         addressRepository.deleteCustomerAddressById(id);
    }
}
