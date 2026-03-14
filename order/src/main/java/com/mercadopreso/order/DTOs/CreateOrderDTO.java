package com.mercadopreso.order.DTOs;

import com.mercadopreso.order.Domains.Item;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDTO {
    @NotNull(message = "address é obrigatorio")
    private String address;

    @NotNull(message = "paymentId é obrigatorio")
    private String paymentId;

    @NotNull(message = "preço final é obrigatorio")
    private BigDecimal finalPrice;

    @NotNull(message = "é necessário pelo menos um item")
    private List<ItemsDTO> items;
}
