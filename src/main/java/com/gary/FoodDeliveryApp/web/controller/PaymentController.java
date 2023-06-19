package com.gary.FoodDeliveryApp.web.controller;

import com.gary.FoodDeliveryApp.exceptions.CreditCardDoesNotExistException;
import com.gary.FoodDeliveryApp.exceptions.EmailAlreadyExistsException;
import com.gary.FoodDeliveryApp.service.paymentService.PaymentService;
import com.gary.FoodDeliveryApp.storage.model.payment.Payment;
import com.gary.FoodDeliveryApp.web.dto.PaymentDTOMapper;
import com.gary.FoodDeliveryApp.web.dto.PaymentRequest;
import com.gary.FoodDeliveryApp.web.security.jwt.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PaymentController {

    private final PaymentService paymentService;

    private final PaymentDTOMapper paymentDTOMapper;

    @PostMapping("/set_payment_method")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Payment setPaymentMethod(@RequestBody PaymentRequest creditCardRequest){

        if (
                creditCardRequest.getCardNumber() == null ||
                        creditCardRequest.getExpirationDate() == null ||
                        creditCardRequest.getCcv() == null ||
                        creditCardRequest.getCardHolderName() == null
        ){
            throw new EmailAlreadyExistsException("The specified username or email already exists");
        }

        return paymentService.setCreditCard(paymentDTOMapper.fromDTO(creditCardRequest, UserContext.getCustomer()));

    }

    @GetMapping("/credit_card/{id}")
    @ResponseBody
    public Payment findCreditCardById(@PathVariable("id") Long id){
        return paymentService.findById(id).orElseThrow(
                () -> new CreditCardDoesNotExistException(id));
    }

    @GetMapping("/delete_credit_card/{id}")
    public void deleteCreditCardById(@PathVariable("id") Long id){
        paymentService.deleteById(id);
    }
}
