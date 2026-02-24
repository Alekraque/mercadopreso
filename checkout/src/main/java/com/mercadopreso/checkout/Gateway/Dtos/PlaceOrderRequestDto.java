package com.mercadopreso.checkout.Gateway.Dtos;

import com.mercadopreso.checkout.Domains.Order;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlaceOrderRequestDto {
    
    @NotNull(message = "tem que ta tendo isso aqui")
    private String orderId;

    @NotNull(message = "tem que ta tendo isso aqui")
    private String userId;

    public Order toCreateOrder() {
        return Order.builder()
                .id(orderId)
                .userId(userId)
                .build();
    }
}
