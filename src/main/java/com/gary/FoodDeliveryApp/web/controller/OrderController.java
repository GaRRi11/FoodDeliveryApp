package com.gary.FoodDeliveryApp.web.controller;

import com.gary.FoodDeliveryApp.exceptions.EmailAlreadyExistsException;
import com.gary.FoodDeliveryApp.exceptions.OrderDoesNotExistException;
import com.gary.FoodDeliveryApp.service.orderService.OrdersService;
import com.gary.FoodDeliveryApp.storage.model.orders.Orders;
import com.gary.FoodDeliveryApp.web.dto.OrderDTOMapper;
import com.gary.FoodDeliveryApp.web.dto.OrdersRequest;
import com.gary.FoodDeliveryApp.web.security.jwt.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrdersService orderService;

    private final OrderDTOMapper orderDTOMapper;

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Orders sendOrder(@RequestBody OrdersRequest ordersRequest){
        if(
                ordersRequest.getCard() == null ||
                        ordersRequest.getItemIds() == null ||
                        ordersRequest.getAddress() == null
        ) {
            throw new EmailAlreadyExistsException("The specified username or email already exists");
        }
        return orderService.setOrder(orderDTOMapper.fromDTO(ordersRequest,UserContext.getCustomer()));
    }

    @GetMapping("/order/{id}")
    @ResponseBody
    public Orders findOrderById(@PathVariable("id") Long id){
        return orderService.findById(id).orElseThrow(() -> new OrderDoesNotExistException(id));
    }

}
