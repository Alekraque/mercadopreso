package com.mercadopreso.order.Gateway;

import com.mercadopreso.order.Client.ShippingClient;
import com.mercadopreso.order.DTOs.ItemsDTO;
import com.mercadopreso.order.DTOs.ShippingDTO;
import com.mercadopreso.order.Domains.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShippingGateway {

    private final ShippingClient shippingClient;

    public void notifyShipping(Order order) {
        List<ItemsDTO> items = order.getItems().stream()
                .map(i -> ItemsDTO.builder()
                        .id(i.getId())
                        .sku(i.getSku())
                        .price(i.getPrice())
                        .build())
                .toList();

        ShippingDTO shippingDTO = ShippingDTO.builder()
                .orderId(order.getId())
                .paymentId(order.getPaymentId())
                .finalPrice(order.getPrecoFinal())
                .items(items)
                .build();

        shippingClient.sendToShipping(shippingDTO);
    }
}
