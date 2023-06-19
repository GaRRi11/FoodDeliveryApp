package com.gary.FoodDeliveryApp.web.controller;

import com.gary.FoodDeliveryApp.service.customerService.CustomerService;
import com.gary.FoodDeliveryApp.service.itemService.ItemService;
import com.gary.FoodDeliveryApp.storage.model.customer.Customer;
import com.gary.FoodDeliveryApp.storage.model.item.Item;
import com.gary.FoodDeliveryApp.web.dto.ItemDTOMapper;
import com.gary.FoodDeliveryApp.web.dto.ItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ItemService itemService;
    private final CustomerService customerService;
    private final ItemDTOMapper itemDTOMapper;

    @PostMapping("/add_item")
    @ResponseStatus(HttpStatus.CREATED  )
    @PreAuthorize("hasRole('ADMIN')")
    public Item addItem (@RequestBody ItemRequest itemRequest) {
        if (
                itemRequest.getName() == null ||
                        itemRequest.getPrice() == null
        ) {
            throw new NullPointerException("The request was malformed or missing required fields");
        }
        return itemService.saveItem(itemDTOMapper.fromDTO(itemRequest));
    }

    @GetMapping("/delete_item/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteItemById(@PathVariable("id") Long id) {
        itemService.deleteItemById(id);
    }



    @GetMapping("/all_users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }


}
