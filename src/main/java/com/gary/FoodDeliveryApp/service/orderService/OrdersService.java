package com.gary.FoodDeliveryApp.service.orderService;

import com.gary.FoodDeliveryApp.storage.model.orders.Orders;

import java.util.Optional;

public interface OrdersService {
    Orders setOrder (Orders orders);
    Optional<Orders> findById(Long id);
    void deleteById(Long id);
}
