package com.gary.FoodDeliveryApp.web.dto;

import com.gary.FoodDeliveryApp.storage.model.item.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemDTOMapper {

    public Item fromDTO (ItemRequest itemRequest){
        return new Item(
                itemRequest.getName(),
                itemRequest.getPrice()
        );
    }
}
