package com.mercadopreso.checkout.Services;

import com.mercadopreso.checkout.Domains.Item;
import com.mercadopreso.checkout.Domains.Order;
import com.mercadopreso.checkout.Gateway.Dtos.PaymentDto.PaymentRequestDto;
import com.mercadopreso.checkout.Gateway.Dtos.PaymentDto.PaymentResponseDto;
import com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto.CartDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class PlaceOrderService {
    public PaymentResponseDto placeOrder(CartDto cart, PaymentRequestDto payment) {
        String orderId = UUID.randomUUID().toString();
        List<Item> items = cart.getItems();
        BigDecimal itemsTotal = items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Order order = Order.builder()
                .id(orderId)
                .userId(cart.getUserId())
                .items(items)
                .finalPrice(itemsTotal.add(cart.getFreight()))
                .status(payment.getStatus())
                .paymentId(payment.getId())
                .build();

        return PaymentResponseDto.fromPaymentRequest(payment);
    }
}
