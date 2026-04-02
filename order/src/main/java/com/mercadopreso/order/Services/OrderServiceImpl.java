package com.mercadopreso.order.Services;

import com.mercadopreso.order.Domains.Enums.OrderStatus;
import com.mercadopreso.order.Domains.Order;
import com.mercadopreso.order.Services.Interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final RabbitTemplate rabbitTemplate;

    public Order createOrder(Order order) {
        Order createdOrder = Order.builder()
                .id(UUID.randomUUID().toString())
                .items(order.getItems())
                .precoFinal(order.getPrecoFinal())
                .status(OrderStatus.PENDING)
                .endereco(order.getEndereco())
                .paymentId(order.getPaymentId())
                .build();

        rabbitTemplate.convertAndSend("fernando-ex", "fernando-rk", createdOrder);

        return createdOrder;
    }
}