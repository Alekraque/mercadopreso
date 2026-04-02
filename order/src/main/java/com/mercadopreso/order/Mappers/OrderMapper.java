package com.mercadopreso.order.Mappers;

import com.mercadopreso.order.DTOs.CreateOrderDTO;
import com.mercadopreso.order.DTOs.ItemsDTO;
import com.mercadopreso.order.Domains.Item;
import com.mercadopreso.order.Domains.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    public Order toDomain(CreateOrderDTO dto) {
        List<Item> items = dto.getItems().stream()
                .map(i -> Item.builder()
                        .id(i.getId())
                        .sku(i.getSku())
                        .price(i.getPrice())
                        .build()
                ).toList();

        return Order.builder()
                .endereco(dto.getAddress())
                .paymentId(dto.getPaymentId())
                .precoFinal(dto.getFinalPrice())
                .items(items)
                .build();
    }

    public CreateOrderDTO toDTO(Order order) {
        List<ItemsDTO> itemsDTO = order.getItems().stream()
                .map(i -> ItemsDTO.builder()
                        .id(i.getId())
                        .sku(i.getSku())
                        .price(i.getPrice())
                        .build())
                .toList();

        return new CreateOrderDTO(
                order.getEndereco(),
                order.getPaymentId(),
                order.getPrecoFinal(),
                itemsDTO
        );
    }
}
