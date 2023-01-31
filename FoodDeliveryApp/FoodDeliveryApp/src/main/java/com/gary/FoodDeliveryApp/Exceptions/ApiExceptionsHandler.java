package com.gary.FoodDeliveryApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionsHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException (ApiRequestException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = {AddressDoesnNotExistException.class})
    public ResponseEntity<Object> handleAddressDoesnNotExistException (AddressDoesnNotExistException e) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;

        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, httpStatus);


    }

    @ExceptionHandler(value = {CreditCardDoesNotExistException.class})
    public ResponseEntity<Object> handleAddressDoesnNotExistException (CreditCardDoesNotExistException e) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;

        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, httpStatus);


    }

    @ExceptionHandler(value = {OrderDoesNotExistException.class})
    public ResponseEntity<Object> handleAddressDoesnNotExistException (OrderDoesNotExistException e) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;

        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, httpStatus);


    }

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    public ResponseEntity<Object> handleAddressDoesnNotExistException (UsernameNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;

        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, httpStatus);


    }
}
