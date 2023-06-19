package com.gary.FoodDeliveryApp.web.dto;

import com.gary.FoodDeliveryApp.service.addressService.AddressService;
import com.gary.FoodDeliveryApp.service.itemService.ItemService;
import com.gary.FoodDeliveryApp.service.paymentService.PaymentService;
import com.gary.FoodDeliveryApp.storage.model.customer.Customer;
import com.gary.FoodDeliveryApp.storage.model.orders.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderDTOMapper {

    private final ItemService itemServiceImpl;

    private final PaymentService customerCreditCardService;

    private final AddressService customerAddressService;

    public Orders fromDTO (OrdersRequest ordersRequest, Customer customer){
        return new Orders(
                itemServiceImpl.findItemsById(ordersRequest.getItemIds()),
                customer,
                customerAddressService.findById(ordersRequest.getAddress()).get(), //gavaswpro
                customerCreditCardService.findById(ordersRequest.getCard()).get()
        );
    }

}
