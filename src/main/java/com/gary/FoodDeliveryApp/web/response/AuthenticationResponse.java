package com.gary.FoodDeliveryApp.web.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gary.FoodDeliveryApp.storage.model.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String token;

    @JsonIgnore
    private Customer customer;

    //davaignore customeri




}
