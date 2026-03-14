package com.mercadopreso.order.DTOs;

import lombok.Builder;
import lombok.Getter;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
public class ShippingDTO {
    private String orderId;
    private String paymentId;
    private BigDecimal finalPrice;
    private List<ItemsDTO> items;
}