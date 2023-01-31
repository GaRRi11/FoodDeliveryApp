package com.gary.FoodDeliveryApp.CreditCard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.gary.FoodDeliveryApp.Customer.Customer;
import lombok.Data;

@Data
@JsonRootName("CustomerCreditCardRequest")
public class CustomerCreditCardRequest {

    private String cardNumber;

    private String expirationDate;

    private String ccv;

    private String cardHolderName;

    private Customer customer;

    @JsonCreator
    public CustomerCreditCardRequest(@JsonProperty("cardnumber") String cardNumber,
                                     @JsonProperty("expirationdate") String expirationDate,
                                     @JsonProperty("ccv") String ccv,
                                     @JsonProperty("cardholdername") String cardHolderName,
                                     Customer customer) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.ccv = ccv;
        this.cardHolderName = cardHolderName;
        this.customer = customer;
    }
}
