package com.gary.FoodDeliveryApp.exceptions;

public class CreditCardDoesNotExistException extends RuntimeException{
    public CreditCardDoesNotExistException(Long id) {
        super("Credit card " + id +" Does Not Exist");
    }
}
