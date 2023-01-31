package com.gary.FoodDeliveryApp.Controller;

import com.gary.FoodDeliveryApp.Address.CustomerAddress;
import com.gary.FoodDeliveryApp.Address.CustomerAddressRequest;
import com.gary.FoodDeliveryApp.Address.CustomerAddressService;
import com.gary.FoodDeliveryApp.CreditCard.CustomerCreditCard;
import com.gary.FoodDeliveryApp.CreditCard.CustomerCreditCardRequest;
import com.gary.FoodDeliveryApp.CreditCard.CustomerCreditCardService;
import com.gary.FoodDeliveryApp.Customer.Customer;
import com.gary.FoodDeliveryApp.Customer.CustomerRegistrationRequest;
import com.gary.FoodDeliveryApp.Item.Item;
import com.gary.FoodDeliveryApp.Item.ItemRequest;
import com.gary.FoodDeliveryApp.Item.ItemService;
import com.gary.FoodDeliveryApp.Orders.Orders;
import com.gary.FoodDeliveryApp.Orders.OrdersRequest;
import com.gary.FoodDeliveryApp.Orders.OrdersService;
import com.gary.FoodDeliveryApp.auth.AuthenticationRequest;
import com.gary.FoodDeliveryApp.auth.AuthenticationResponse;
import com.gary.FoodDeliveryApp.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CustomerController {
    private final OrdersService orderService;
    private final ItemService itemService;
    private final CustomerAddressService customerAddressService;
    private final CustomerCreditCardService customerCreditCardService;
    private final AuthenticationService authenticationService;
    private Customer customer;


    @PostMapping("/auth/register")
    public ResponseEntity <AuthenticationResponse> register(
            @RequestBody CustomerRegistrationRequest request
    ){
        return ResponseEntity.ok(authenticationService.register(request));

    }

    @PostMapping("/auth/authenticate")
    public AuthenticationResponse signIn(
            @RequestBody AuthenticationRequest request
    ){

        AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);
        this.customer = authenticationResponse.getCustomer();
        return authenticationResponse;
    }


    @GetMapping("/menu")
    @ResponseBody
    public List<Item> items(){
        return itemService.getAllItems();
    }
    @PostMapping("/add_item")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Item addItem(@RequestBody ItemRequest itemRequest){
        return itemService.saveItem(itemRequest);
    }
    //for admin



    @PostMapping("/set_address")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CustomerAddress setCustomerAddress(@RequestBody CustomerAddressRequest customerAddressRequest){
        return customerAddressService.setAddress(customerAddressRequest,customer);
    }
    @GetMapping("/address/{id}")
    @ResponseBody
    public CustomerAddress findAddressById(@PathVariable("id") Long id){
        return customerAddressService.findById(id);
    }

    @GetMapping("/delete_address/{id}")
    public void deleteAddressById(@PathVariable("id") Long id){
         customerAddressService.deleteById(id);
    }


    @PostMapping("/set_payment_method")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CustomerCreditCard setPaymentMethod(@RequestBody CustomerCreditCardRequest creditCardRequest){
        return customerCreditCardService.setCreditCard(creditCardRequest,customer);
    }

    @GetMapping("/credit_card/{id}")
    @ResponseBody
    public CustomerCreditCard findCreditCardById(@PathVariable("id") Long id){
        return customerCreditCardService.findById(id);
    }

    @GetMapping("/delete_credit_card/{id}")
    public void deleteCreditCardById(@PathVariable("id") Long id){
        customerCreditCardService.deleteById(id);
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Orders sendOrder(@RequestBody OrdersRequest ordersRequest){
         return orderService.setOrder(ordersRequest, customer);
    }

    @GetMapping("/order/{id}")
    @ResponseBody
    public Orders findOrderById(@PathVariable("id") Long id){
       return orderService.findById(id);
    }

    @GetMapping("/delete_order/{id}")
    public void deleteOrderById(@PathVariable("id") Long id){
        orderService.deleteById(id);
    }

    //TODO:controllers for admin to see all customer by ids, orders, addesses and cards

}
