package com.mercadopreso.checkout.Gateway.Dtos.OrderDto;

import com.mercadopreso.checkout.Gateway.Dtos.itemDto.ItemsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private String id;
    private String userId;
    private List<ItemsDto> items;
    private BigDecimal finalPrice;
    private String status;
    private String address;
    private String paymentId;
}
