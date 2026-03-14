package com.mercadopreso.order.Services;

import com.mercadopreso.order.Domains.Enums.OrderStatus;
import com.mercadopreso.order.Domains.Order;
import com.mercadopreso.order.Gateway.ShippingGateway;
import com.mercadopreso.order.Repository.Interfaces.OrderRepositoryInterface;
import com.mercadopreso.order.Services.Interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepositoryInterface orderRepository;
    private final ShippingGateway shippingGateway;

    public Order createOrder(Order order) {
        Order createdOrder = Order.builder()
                .id(UUID.randomUUID().toString())
                .items(order.getItems())
                .precoFinal(order.getPrecoFinal())
                .status(OrderStatus.PENDING)
                .endereco(order.getEndereco())
                .paymentId(order.getPaymentId())
                .build();

        Order savedOrder = orderRepository.save(createdOrder);

        //shippingGateway.notifyShipping(savedOrder);

        return savedOrder;
    }
}
