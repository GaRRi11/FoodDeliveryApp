package com.gary.FoodDeliveryApp.Orders;

import com.gary.FoodDeliveryApp.Address.CustomerAddressRepository;
import com.gary.FoodDeliveryApp.CreditCard.CustomerCreditCardRepository;
import com.gary.FoodDeliveryApp.Customer.Customer;
import com.gary.FoodDeliveryApp.Exceptions.AddressDoesnNotExistException;
import com.gary.FoodDeliveryApp.Exceptions.CreditCardDoesNotExistException;
import com.gary.FoodDeliveryApp.Exceptions.OrderDoesNotExistException;
import com.gary.FoodDeliveryApp.Item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;

    private final ItemRepository itemRepository;

    private final CustomerAddressRepository customerAddressRepository;

    private final CustomerCreditCardRepository customerCreditCardRepository;

    public Orders setOrder(OrdersRequest ordersRequest,
                         Customer customer){
        Orders orders = new Orders(
                List.of(itemRepository.findById(ordersRequest.getWhichItem()).orElseThrow()),
                customer,
                customerAddressRepository.findById(ordersRequest.getWhichAddress()).orElseThrow(
                        ()-> new AddressDoesnNotExistException(ordersRequest.getWhichAddress())
                ),
                customerCreditCardRepository.findById(ordersRequest.getWhichCard()).orElseThrow(
                        () -> new CreditCardDoesNotExistException(ordersRequest.getWhichCard())
                )
        );
        ordersRepository.save(orders);
        return orders;

    }

    public Orders findById(Long id) {
        return ordersRepository.findById(id).orElseThrow(
                () -> new OrderDoesNotExistException(id)
        );
    }

    public void deleteById(Long id) {
        ordersRepository.deleteById(id);
    }
}
