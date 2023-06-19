package com.gary.FoodDeliveryApp.exceptions;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException(String email) {
        super("User With Email: " + email + "Does Not Exist");
    }
}
