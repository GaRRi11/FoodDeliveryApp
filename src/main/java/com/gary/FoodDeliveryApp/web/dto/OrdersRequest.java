package com.gary.FoodDeliveryApp.web.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrdersRequest {

    private Long card;

    private Long address;

    private List<Long> itemIds;


    @JsonCreator
    public OrdersRequest(@JsonProperty("card") Long card,
                         @JsonProperty("address") Long address,
                         @JsonProperty("item") List<Long> itemIds) {
        this.card= card;
        this.address = address;
        this.itemIds = itemIds;
    }
}
