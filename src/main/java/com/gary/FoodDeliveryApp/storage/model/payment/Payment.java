package com.gary.FoodDeliveryApp.storage.model.payment;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gary.FoodDeliveryApp.storage.model.customer.Customer;
import com.gary.FoodDeliveryApp.storage.model.orders.Orders;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static jakarta.persistence.GenerationType.AUTO;

@Entity(name = "CustomerCreditCard")
@Table(
        name = "customer_credit_card",
        uniqueConstraints = {
                @UniqueConstraint(name = "customer_card_number_unique", columnNames = "card_number")
        }

)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @SequenceGenerator(
            name = "customer_credit_card_sequence",
            sequenceName = "customer_credit_card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = AUTO,
            generator = "customer_credit_card_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "card_number",
            nullable = false
    )
    private String cardNumber;


    @Column(
            name = "expiration_date",
            nullable = false,
            length = 5
    )
    private String expirationDate;



    @Column(
            name = "ccv",
            nullable = false,
            length = 3
    )
    private String ccv;

    @Column(
            name = "card_holder_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String cardHolderName;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "customer_credit_card_fk"
            )
    )
    private Customer customer;

    @JsonIgnore
    @OneToOne(mappedBy = "payment")
    private Orders orders;

    public Payment(String  cardNumber,
                   String expirationDate,
                   String ccv,
                   String cardHolderName,
                   Customer customer) {
        if(cardNumber == null || cardNumber.length() != 16 || !isValidNumber(cardNumber)) {
            throw new IllegalArgumentException("Invalid credit card number " + cardNumber);
        }
        this.cardNumber = cardNumber;
        if(! isValidName(cardHolderName)) {
            throw new IllegalArgumentException("Invalid card holder name " + cardHolderName);
        }
        this.cardHolderName = cardHolderName;
        if(ccv == null || ccv.length() != 3 || !isValidNumber(ccv)) {
            throw new IllegalArgumentException("Invalid security code " + ccv);
        }
        if (isExpired(expirationDate)){
            throw new IllegalArgumentException("Card is expired");
        }
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.ccv = ccv;
        this.cardHolderName = cardHolderName;
        this.customer = customer;
    }

    private boolean isExpired(String expirationDate){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy/dd");
        LocalDate expiration = LocalDate.parse(expirationDate + "/01", formatter);
        return expiration.isBefore(currentDate);

    }

    private boolean isValidNumber(String number){
        return number.matches("[0-9]+");

    }

    private boolean isValidName(String name){
        if(name == null) return false;
        name = name.trim().toUpperCase();
        return name.length() >= 3 && name.matches("[A-Z\\.\\s]+");
    }


}
