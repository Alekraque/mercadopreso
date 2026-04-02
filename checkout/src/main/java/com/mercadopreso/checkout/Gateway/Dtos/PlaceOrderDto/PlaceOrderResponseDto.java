package com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto;

import com.mercadopreso.checkout.Gateway.Dtos.itemDto.ItemsDto;
import jakarta.validation.constraints.NotNull;
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
public class PlaceOrderResponseDto {
    @NotNull(message = "address é obrigatorio")
    private String address;

    @NotNull(message = "paymentId é obrigatorio")
    private String paymentId;

    @NotNull(message = "preço final é obrigatorio")
    private BigDecimal finalPrice;

    @NotNull(message = "é necessário pelo menos um item")
    private List<ItemsDto> items;
}
