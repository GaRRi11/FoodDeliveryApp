package com.gary.FoodDeliveryApp.web.controller;

import com.gary.FoodDeliveryApp.exceptions.AddressDoesnNotExistException;
import com.gary.FoodDeliveryApp.service.addressService.AddressService;
import com.gary.FoodDeliveryApp.storage.model.address.Address;
import com.gary.FoodDeliveryApp.web.dto.AddressDTOMapper;
import com.gary.FoodDeliveryApp.web.dto.AddressRequest;
import com.gary.FoodDeliveryApp.web.security.jwt.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AddressController {
    private final AddressService addressService;

    private final AddressDTOMapper addressDTOMapper;

    @PostMapping("/set_address")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Address setCustomerAddress(@RequestBody AddressRequest addressRequest){

        if (
                addressRequest.getStreet() == null ||
                        addressRequest.getZipcode() == null
        ){
            throw new NullPointerException("The request was malformed or missing required fields");
        }

        return addressService.setAddress(addressDTOMapper.fromDTO(addressRequest,UserContext.getCustomer()));

    }
    @GetMapping("/address/{id}")
    @ResponseBody
    public Address findAddressById(@PathVariable("id") Long id){
        return addressService.findById(id).orElseThrow(
                () -> new AddressDoesnNotExistException(id));
    }

    @DeleteMapping("/delete_address/{id}")
    public void deleteAddressById(@PathVariable("id") Long id){
         addressService.deleteById(id);
    }



}
