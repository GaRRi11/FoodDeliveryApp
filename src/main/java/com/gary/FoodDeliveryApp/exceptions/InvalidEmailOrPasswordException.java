package com.gary.FoodDeliveryApp.exceptions;

public class InvalidEmailOrPasswordException extends RuntimeException{
    public InvalidEmailOrPasswordException(String message) {
        super(message);
    }
}
