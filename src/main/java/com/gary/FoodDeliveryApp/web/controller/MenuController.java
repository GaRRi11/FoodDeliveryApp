package com.gary.FoodDeliveryApp.web.controller;

import com.gary.FoodDeliveryApp.service.itemService.ItemService;
import com.gary.FoodDeliveryApp.storage.model.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MenuController {

    private final ItemService itemService;

    @GetMapping("/menu")
    @ResponseBody
    public List<Item> items(){
        return itemService.getAllItems();
    }

}
