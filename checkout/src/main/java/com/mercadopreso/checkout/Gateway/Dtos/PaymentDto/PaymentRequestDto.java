package com.mercadopreso.checkout.Gateway.Dtos.PaymentDto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentRequestDto {
    @NotNull(message = "paymentId é obrigatório")
    private String id;

    @NotNull(message = "type é obrigatório")
    private String type;

    @NotNull(message = "hashId é obrigatório")
    private String hashId;

    @NotNull(message = "gateway é obrigatório")
    private String gateway;

    @NotNull(message = "status é obrigatório")
    private String status;
}
