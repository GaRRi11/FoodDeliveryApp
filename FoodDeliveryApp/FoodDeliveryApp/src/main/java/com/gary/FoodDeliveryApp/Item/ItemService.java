package com.gary.FoodDeliveryApp.Item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item saveItem(ItemRequest itemRequest){
        Item item = new Item(
                itemRequest.getName(),
                itemRequest.getQuantity(),
                itemRequest.getPrice()
        );
        itemRepository.save(item);
        return item;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
