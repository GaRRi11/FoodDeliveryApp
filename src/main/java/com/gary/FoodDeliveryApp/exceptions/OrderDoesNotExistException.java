package com.gary.FoodDeliveryApp.exceptions;

public class OrderDoesNotExistException extends RuntimeException{
    public OrderDoesNotExistException(Long id) {
        super("Order " + id + " Does Not Exist");
    }
}
