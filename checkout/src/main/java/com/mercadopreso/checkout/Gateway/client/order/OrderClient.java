package com.mercadopreso.checkout.Gateway.client.order;

import com.mercadopreso.checkout.Gateway.Dtos.OrderDto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "order", url = "url do microsserviço de order")
public interface OrderClient {
    @PostMapping("/order/create")
    void sendOrder(@RequestBody OrderDto order);
}
