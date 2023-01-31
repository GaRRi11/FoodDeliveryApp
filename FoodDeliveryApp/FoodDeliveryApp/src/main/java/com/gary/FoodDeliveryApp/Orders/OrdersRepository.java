package com.gary.FoodDeliveryApp.Orders;

import com.gary.FoodDeliveryApp.Orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {


}
