package com.gary.FoodDeliveryApp.storage.repository.order;

import com.gary.FoodDeliveryApp.storage.model.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {


}
