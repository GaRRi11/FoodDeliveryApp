package com.gary.FoodDeliveryApp.exceptions;

public class InvalidJwtTokenException extends RuntimeException{
    public InvalidJwtTokenException(String message){
        super(message);
    }

}
