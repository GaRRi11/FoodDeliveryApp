package com.gary.FoodDeliveryApp.storage.model.orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gary.FoodDeliveryApp.storage.model.address.Address;
import com.gary.FoodDeliveryApp.storage.model.payment.Payment;
import com.gary.FoodDeliveryApp.storage.model.customer.Customer;
import com.gary.FoodDeliveryApp.storage.model.item.Item;
import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Order")
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "order_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(name = "total_cost")
    private Double totalCost;


    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "customer_id_fk"
            )
    )
    private Customer customer;

    @OneToMany(
            mappedBy = "orders",
            orphanRemoval = true,
            cascade = {CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    private List<Item> items = new ArrayList<>();


    @Column(name = "item_ids")
    private List<Long> itemIds = new ArrayList<>();


    @OneToOne
    @JoinColumn(
            name = "customer_address_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "customer_address_fk"
            )
    )
    private Address address;


    @OneToOne
    @JoinColumn(
            name = "customer_payment_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "customer_payment_fk"
            )
    )
    private Payment payment;


    public Orders(List<Item> items,
                  Customer customer,
                  Address address,
                  Payment payment) {
        this.customer = customer;
        this.items = items;
        this.totalCost = calculateTotalCost(this.items);
        this.createdAt = LocalDateTime.now();
        this.address = address;
        this.payment = payment;

        for (Item item : items) {
            this.itemIds.add(item.getId());
        }

    }

    private double calculateTotalCost(List<Item> items) {
        double cost = 0L;
        for(Item item : items) {
            cost += item.getPrice()*100;
        }
        return cost/100.0;
    }

}


