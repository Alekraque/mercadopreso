package com.mercadopreso.cart.gateways.dto;

import com.mercadopreso.cart.domain.Item;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {
    private String userId;
    private List<Item> itemIdList;
}
