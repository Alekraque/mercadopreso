package com.mercadopreso.checkout.Gateway.Dtos.PaymentDto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentRequestDto {
    private String id;

    @NotNull(message = "type é obrigatório")
    private String type;

    private String hashId;

    @NotNull(message = "gateway é obrigatório")
    private String gateway;

    private String status;

    private BigDecimal amount;

    private String userId;
}
