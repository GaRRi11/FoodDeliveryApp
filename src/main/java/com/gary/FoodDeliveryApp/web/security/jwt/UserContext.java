package com.gary.FoodDeliveryApp.web.security.jwt;

import com.gary.FoodDeliveryApp.storage.model.customer.Customer;

public class UserContext {

    private static ThreadLocal<Customer> customerThreads = new ThreadLocal<>();


    public static Customer getCustomer(){
        return customerThreads.get();
    }

    public static void setCustomer (Customer customer){
        customerThreads.set(customer);
    }
}
