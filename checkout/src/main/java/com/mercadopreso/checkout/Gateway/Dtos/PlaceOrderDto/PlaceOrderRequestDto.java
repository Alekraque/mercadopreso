package com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto;

import com.mercadopreso.checkout.Gateway.Dtos.PaymentDto.PaymentRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlaceOrderRequestDto {
    @Valid
    @NotNull(message = "cart é obrigatório")
    private CartDto cart;

    @Valid
    @NotNull(message = "payment é obrigatório")
    private PaymentRequestDto payment;
}
