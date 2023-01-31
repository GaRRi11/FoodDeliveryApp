package com.gary.FoodDeliveryApp.Item;

import com.gary.FoodDeliveryApp.Item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findById (Long id);
}
