package com.mercadopreso.checkout.Gateway.client.payment;

import com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto.PaymentRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment", url = "http://localhost:8081")
public interface PaymentClient {

    @PostMapping("/payment/pre-authorize")
    PaymentRequestDto preAuthorize(
            @RequestBody PaymentRequestDto payment
    );
}
