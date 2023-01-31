package com.gary.FoodDeliveryApp.Orders;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrdersRequest {

    private Long whichCard;

    private Long whichAddress;

    private Long whichItem;


    @JsonCreator
    public OrdersRequest(@JsonProperty("whichcard") Long whichCard,
                         @JsonProperty("whichaddress") Long whichAddress,
                         @JsonProperty("whichitem") Long whichItem) {
        this.whichCard = whichCard;
        this.whichAddress = whichAddress;
        this.whichItem = whichItem;
    }
}
