package com.gary.FoodDeliveryApp.web.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.gary.FoodDeliveryApp.storage.model.customer.Role;
import lombok.Data;

@Data
@JsonRootName("CustomerRegistrationRequest")
public class CustomerRegistrationRequest {

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private Role role;

    @JsonCreator
    public CustomerRegistrationRequest(@JsonProperty("firstname") String firstname,
                                       @JsonProperty("lastname") String lastname,
                                       @JsonProperty("email") String email,
                                       @JsonProperty("password") String password,
                                       @JsonProperty("role") String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;

        if (role.equals("admin")){
            this.role = Role.ADMIN;
        }else if(role.equals("user")) {
            this.role = Role.USER;
        }

    }
}
