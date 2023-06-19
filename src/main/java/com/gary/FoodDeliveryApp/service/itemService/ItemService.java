package com.gary.FoodDeliveryApp.service.itemService;

import com.gary.FoodDeliveryApp.storage.model.item.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item saveItem(Item item);
    Optional<Item> findById (Long id);
    List<Item> findItemsById (List<Long> itemIds);
    void deleteItemById(Long id);
    List<Item> getAllItems();
}
