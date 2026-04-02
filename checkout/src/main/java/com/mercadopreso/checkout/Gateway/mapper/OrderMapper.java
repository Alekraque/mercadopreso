package com.mercadopreso.checkout.Gateway.mapper;

import com.mercadopreso.checkout.Domains.Item;
import com.mercadopreso.checkout.Gateway.Dtos.OrderDto.OrderDto;
import com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto.CartDto;
import com.mercadopreso.checkout.Gateway.Dtos.itemDto.ItemsDto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class OrderMapper {
    public static OrderDto fromCart(CartDto cart, BigDecimal finalPrice) {
        if (cart == null) {
            return null;
        }

        List<Item> items = cart.getItems();
        List<ItemsDto> itemDtos = items == null ? Collections.emptyList() : items.stream()
                .map(item -> ItemsDto.builder()
                        .id(item.getId())
                        .sku(item.getSku())
                        .price(item.getPrice())
                        .build())
                .toList();

        return OrderDto.builder()
                .id(cart.getCartId())
                .userId(cart.getUserId())
                .items(itemDtos)
                .finalPrice(finalPrice)
                .status("PENDING")
                .address("")
                .paymentId(cart.getPaymentId())
                .build();
    }
}
