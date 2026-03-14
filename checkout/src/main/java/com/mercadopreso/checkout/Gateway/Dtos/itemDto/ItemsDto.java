package com.mercadopreso.checkout.Gateway.Dtos.itemDto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ItemsDto {
    @NotNull(message = "id é obrigatório")
    private String id;

    @NotNull(message = "SKU é obrigatório")
    private String sku;

    @NotNull(message = "Price é obrigatório")
    private BigDecimal price;
}
