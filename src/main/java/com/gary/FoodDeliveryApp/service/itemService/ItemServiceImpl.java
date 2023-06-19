package com.gary.FoodDeliveryApp.service.itemService;

import com.gary.FoodDeliveryApp.storage.model.item.Item;
import com.gary.FoodDeliveryApp.storage.repository.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    public Item saveItem(Item item){
         return itemRepository.save(item);
    }

    public Optional<Item> findById (Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> findItemsById (List<Long> itemIds) {
        return itemRepository.findAllById(itemIds);
    }

    public void deleteItemById(Long id){
        itemRepository.deleteItemById(id);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
