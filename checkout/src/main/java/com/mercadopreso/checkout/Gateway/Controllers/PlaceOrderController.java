package com.mercadopreso.checkout.Gateway.Controllers;

import com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto.PaymentRequestDto;
import com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto.CartDto;
import com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto.PlaceOrderRequestDto;
import com.mercadopreso.checkout.Gateway.client.payment.PaymentClient;
import com.mercadopreso.checkout.Services.PlaceOrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/checkout")
public class PlaceOrderController {
    private final PlaceOrderService placeOrderService;
    private final PaymentClient paymentClient;

    @PostMapping("/place-order")
    public ResponseEntity<CartDto> placeOrder(@RequestBody @Valid PlaceOrderRequestDto placeOrderRequestDto) {
        CartDto cartDto = placeOrderService.placeOrder(
                placeOrderRequestDto.getCart()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(cartDto);
    }


        @PostMapping("/checkout-pre-authorize")
        public PaymentRequestDto preAuthorizePayment() {
            return paymentClient.preAuthorize(
                    PaymentRequestDto.builder()
                            .paymentId(UUID.randomUUID().toString())
                            .finalPrice(BigDecimal.TEN)
                            .build()
            );
        }
}
