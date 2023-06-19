package com.gary.FoodDeliveryApp.web.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("CustomerCreditCardRequest")
public class PaymentRequest {

    private String cardNumber;

    private String expirationDate;

    private String ccv;

    private String cardHolderName;


    @JsonCreator
    public PaymentRequest(@JsonProperty("cardnumber") String cardNumber,
                          @JsonProperty("expirationdate") String expirationDate,
                          @JsonProperty("ccv") String ccv,
                          @JsonProperty("cardholdername") String cardHolderName) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.ccv = ccv;
        this.cardHolderName = cardHolderName;
    }
}
