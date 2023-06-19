package com.gary.FoodDeliveryApp.storage.model.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.gary.FoodDeliveryApp.storage.model.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import static jakarta.persistence.GenerationType.AUTO;

@Entity(name = "CustomerAddress")
@Table(name = "customer_address")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("customerAddress")
public class Address {
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

    public Address(String street, String zipCode, Customer customer) {
        this.street = street;
        this.zipCode = zipCode;
        this.customer = customer;
    }
}
