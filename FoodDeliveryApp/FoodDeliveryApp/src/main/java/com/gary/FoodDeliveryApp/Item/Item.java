package com.gary.FoodDeliveryApp.Item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gary.FoodDeliveryApp.Orders.Orders;
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

    @Column(
            name = "quantity",
            nullable = false
    )
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    @JsonIgnore
    @ManyToOne()
    private Orders orders;


    public Item(String name,
                 Integer quantity,
                Double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
