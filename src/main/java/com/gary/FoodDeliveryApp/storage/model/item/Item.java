package com.gary.FoodDeliveryApp.storage.model.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gary.FoodDeliveryApp.storage.model.orders.Orders;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;

@Entity(name = "Item")
@Table(name = "item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = AUTO,
            generator = "item_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;


    @Column(name = "price")
    private Double price;

    @JsonIgnore
    @ManyToOne()
    private Orders orders;


    public Item(String name,
                Double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }
}
