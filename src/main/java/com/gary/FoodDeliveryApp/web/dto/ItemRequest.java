package com.gary.FoodDeliveryApp.web.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("ItemRequest")
public class ItemRequest {
    private String name;
    private Double price;

    @JsonCreator
    public ItemRequest(@JsonProperty("name") String name,
                       @JsonProperty("price") Double price) {
        this.name = name;
        this.price = price;
    }
}
