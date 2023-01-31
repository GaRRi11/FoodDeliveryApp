package com.gary.FoodDeliveryApp.Customer;

import com.gary.FoodDeliveryApp.Address.CustomerAddress;
import com.gary.FoodDeliveryApp.CreditCard.CustomerCreditCard;
import com.gary.FoodDeliveryApp.Orders.Orders;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;

@Entity(name = "Customer")
@Table(
        name = "customer",
        uniqueConstraints = {
                @UniqueConstraint(name = "customer_email_unique", columnNames = "email")
        }

)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements UserDetails {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = AUTO,
            generator = "customer_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(

            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(
            mappedBy = "customer",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.EAGER
    )
    private List<CustomerCreditCard> creditCards = new ArrayList<>();

    @OneToMany(
            mappedBy = "customer",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.EAGER
    )
    private List<CustomerAddress> addresses = new ArrayList<>();

    @OneToMany(
            mappedBy = "customer",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.EAGER
    )
    private List<Orders> orders = new ArrayList<>();


    public Customer(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
