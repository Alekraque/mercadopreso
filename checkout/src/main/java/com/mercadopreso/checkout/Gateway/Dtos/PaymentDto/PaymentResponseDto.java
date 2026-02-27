package com.mercadopreso.checkout.Gateway.Dtos.PaymentDto;

public record PaymentResponseDto(
        String hashId,
        String status
) {
    public static PaymentResponseDto fromPaymentRequest(PaymentRequestDto paymentRequestDto) {
        return new PaymentResponseDto(
                paymentRequestDto.getHashId(),
                paymentRequestDto.getStatus()
        );
    }
}
