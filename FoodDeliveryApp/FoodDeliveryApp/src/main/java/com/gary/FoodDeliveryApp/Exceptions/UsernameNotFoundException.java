package com.gary.FoodDeliveryApp.Exceptions;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException(String email) {
        super("User With Email: " + email + "Does Not Exist");
    }
}
