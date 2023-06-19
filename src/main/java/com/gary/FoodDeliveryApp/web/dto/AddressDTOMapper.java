package com.gary.FoodDeliveryApp.web.dto;

import com.gary.FoodDeliveryApp.storage.model.address.Address;
import com.gary.FoodDeliveryApp.storage.model.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class AddressDTOMapper {

    public Address fromDTO (AddressRequest addressRequest, Customer customer){
        return new Address(
                addressRequest.getStreet(),
                addressRequest.getZipcode(),
                customer
        );
    }
}
