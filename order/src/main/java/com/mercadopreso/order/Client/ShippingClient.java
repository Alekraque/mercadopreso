package com.mercadopreso.order.Client;

import com.mercadopreso.order.DTOs.ShippingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "shipping-service", url = "${services.shipping.url}")
public interface ShippingClient {

    @PostMapping("/shipping/create")
    void sendToShipping(@RequestBody ShippingDTO shippingDTO);
}
