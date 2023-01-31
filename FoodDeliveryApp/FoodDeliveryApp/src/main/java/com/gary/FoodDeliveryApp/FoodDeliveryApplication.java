package com.gary.FoodDeliveryApp;

import com.gary.FoodDeliveryApp.Address.CustomerAddressRepository;
import com.gary.FoodDeliveryApp.CreditCard.CustomerCreditCardRepository;
import com.gary.FoodDeliveryApp.Customer.CustomerRepository;
import com.gary.FoodDeliveryApp.Item.ItemRepository;
import com.gary.FoodDeliveryApp.Orders.OrdersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FoodDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryApplication.class, args);


	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
										CustomerAddressRepository customerAddressRepository,
										CustomerCreditCardRepository customerCreditCardRepository,
										ItemRepository itemRepository,
										OrdersRepository ordersRepository) {
		return args -> {







		};

	}


}
