package com.gary.FoodDeliveryApp.service.orderService;

import com.gary.FoodDeliveryApp.storage.model.orders.Orders;
import com.gary.FoodDeliveryApp.storage.repository.order.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService{

    private final OrdersRepository ordersRepository;

    public Orders setOrder (Orders orders){
       return ordersRepository.save(orders);
    }


    public Optional<Orders> findById(Long id) {
        return ordersRepository.findById(id);
    }
    public void deleteById(Long id) {
        ordersRepository.deleteById(id);
    }
}
