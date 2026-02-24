package com.mercadopreso.checkout.Gateway.Dtos;


import com.mercadopreso.checkout.Domains.Order;

public record PlaceOrderResponseDto(
        String userId,
        String orderId
) {
    public static PlaceOrderResponseDto fromOrder(Order order) {
        return new PlaceOrderResponseDto(
                order.getUserId(),
                order.getId()
        );
    }
}
