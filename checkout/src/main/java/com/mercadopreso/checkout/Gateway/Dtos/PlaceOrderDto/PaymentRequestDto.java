package com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDto {
    private BigDecimal finalPrice;
    private String paymentId;
}
