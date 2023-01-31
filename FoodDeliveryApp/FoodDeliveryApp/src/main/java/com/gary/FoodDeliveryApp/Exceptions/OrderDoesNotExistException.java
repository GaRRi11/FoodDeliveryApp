package com.gary.FoodDeliveryApp.Exceptions;

public class OrderDoesNotExistException extends RuntimeException{
    public OrderDoesNotExistException(Long id) {
        super("Order " + id + " Does Not Exist");
    }
}
