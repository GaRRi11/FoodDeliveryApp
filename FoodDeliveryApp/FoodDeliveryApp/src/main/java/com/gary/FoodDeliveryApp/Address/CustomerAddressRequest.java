package com.gary.FoodDeliveryApp.Address;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.gary.FoodDeliveryApp.Customer.Customer;
import lombok.Data;

@Data
@JsonRootName("customerAddress")
public class CustomerAddressRequest {

    private String street;

    private String zipcode;

    private Customer customer;


    @JsonCreator
    public CustomerAddressRequest(
                           @JsonProperty("street") String street,
                           @JsonProperty("zipcode") String zipCode,
                           Customer customer) {
        this.street = street;
        this.zipcode = zipCode;
        this.customer = customer;
    }
}
