package com.mercadopreso.order.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemsDTO {
    @NotNull(message = "id é obrigatório")
    private String id;

    @NotNull(message = "SKU é obrigatório")
    private String sku;

    @NotNull(message = "Price é obrigatório")
    private BigDecimal price;
}
