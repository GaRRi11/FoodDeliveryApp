package com.gary.FoodDeliveryApp.storage.repository.item;

import com.gary.FoodDeliveryApp.storage.model.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findById (Long id);


    @Transactional
    @Modifying
    @Query("DELETE FROM Item u WHERE u.id = ?1")
    void deleteItemById(Long id);
}
