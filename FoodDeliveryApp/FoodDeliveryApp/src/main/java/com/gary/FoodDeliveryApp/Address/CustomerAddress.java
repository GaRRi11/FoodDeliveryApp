package com.gary.FoodDeliveryApp.Address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.gary.FoodDeliveryApp.Customer.Customer;
import com.gary.FoodDeliveryApp.Orders.Orders;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;

@Entity(name = "CustomerAddress")
@Table(
        name = "customer_address",
        uniqueConstraints = {
                @UniqueConstraint(name = "customer_street_unique", columnNames = "street")
        }

)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("customerAddress")
public class CustomerAddress {
    @Id
    @SequenceGenerator(
            name = "customer_address_sequence",
            sequenceName = "customer_address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = AUTO,
            generator = "customer_address_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "street",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String street;

    @Column(
            name = "zip_code",
            nullable = false
    )
    private String zipCode;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "customer_address_fk"
            )
    )
    private Customer customer;

    @JsonIgnore
    @OneToMany(
            mappedBy = "customerAddress",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Orders> orders = new ArrayList<>();

    public CustomerAddress(String street, String zipCode, Customer customer) {
        this.street = street;
        this.zipCode = zipCode;
        this.customer = customer;
    }
}
