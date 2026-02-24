package com.mercadopreso.checkout.Services;

import com.mercadopreso.checkout.Domains.Order;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlaceOrderService {
    public Order createPlaceOrder(Order order) {
        String orderId = UUID.randomUUID().toString();

        return Order.builder()
                .id(orderId)
                .userId(order.getUserId())
                .build();
    }
}
