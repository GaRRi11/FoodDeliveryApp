package com.gary.FoodDeliveryApp.Exceptions;

public class AddressDoesnNotExistException extends RuntimeException{
    public AddressDoesnNotExistException(Long id) {
        super("Address " + id + " Does Not Exist.");
    }
}
