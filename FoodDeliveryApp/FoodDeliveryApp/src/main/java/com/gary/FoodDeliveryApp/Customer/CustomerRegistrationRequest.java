package com.gary.FoodDeliveryApp.Customer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("CustomerRegistrationRequest")
public class CustomerRegistrationRequest {

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    @JsonCreator
    public CustomerRegistrationRequest(@JsonProperty("firstname") String firstname,
                                       @JsonProperty("lastname") String lastname,
                                       @JsonProperty("email") String email,
                                       @JsonProperty("password") String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
}
