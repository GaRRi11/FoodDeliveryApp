package com.gary.FoodDeliveryApp.Address;

import com.gary.FoodDeliveryApp.Customer.Customer;
import com.gary.FoodDeliveryApp.Exceptions.AddressDoesnNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerAddressService {

    private final CustomerAddressRepository customerAddressRepository;


    public CustomerAddress setAddress (CustomerAddressRequest customerAddressRequest,
                            Customer customer){
        CustomerAddress customerAddress = new CustomerAddress(
                customerAddressRequest.getStreet(),
                customerAddressRequest.getZipcode(),
                customer);
        customerAddressRepository.save(customerAddress);
        return customerAddress;

    }

    public CustomerAddress findById(Long id) {
        return customerAddressRepository.findById(id).orElseThrow(
                () -> new AddressDoesnNotExistException(id)
        );
    }

    public void deleteById(Long id){
         customerAddressRepository.deleteCustomerAddressById(id);
    }
}
