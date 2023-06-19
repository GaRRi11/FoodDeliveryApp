package com.gary.FoodDeliveryApp;

import com.gary.FoodDeliveryApp.storage.repository.address.AddressRepository;
import com.gary.FoodDeliveryApp.storage.repository.payment.PaymentRepository;
import com.gary.FoodDeliveryApp.storage.repository.customer.CustomerRepository;
import com.gary.FoodDeliveryApp.storage.repository.item.ItemRepository;
import com.gary.FoodDeliveryApp.storage.repository.order.OrdersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FoodDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryApplication.class, args);
	}


}
