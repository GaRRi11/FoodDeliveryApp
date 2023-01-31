package com.gary.FoodDeliveryApp.Item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("ItemRequest")
public class ItemRequest {
    private String name;

    private Integer quantity;

    private Double price;

    @JsonCreator
    public ItemRequest(@JsonProperty("name") String name,
                       @JsonProperty("quantity") Integer quantity,
                       @JsonProperty("price") Double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
