package com.gary.FoodDeliveryApp.web.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.gary.FoodDeliveryApp.storage.model.customer.Customer;
import lombok.Data;

@Data
@JsonRootName("customerAddress")
public class AddressRequest {

    private String street;

    private String zipcode;



    @JsonCreator
    public AddressRequest(
                           @JsonProperty("street") String street,
                           @JsonProperty("zipcode") String zipCode,
                           Customer customer) {
        this.street = street;
        this.zipcode = zipCode;
    }


}
