package com.mercadopreso.order.Controller;

import com.mercadopreso.order.DTOs.CreateOrderDTO;
import com.mercadopreso.order.Domains.Order;
import com.mercadopreso.order.Mappers.OrderMapper;
import com.mercadopreso.order.Services.Interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class CreateOrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping("/create")
    public ResponseEntity<CreateOrderDTO> createOrder(@RequestBody CreateOrderDTO dto){

        Order order = orderMapper.toDomain(dto);
        Order createdOrder = orderService.createOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderMapper.toDTO(createdOrder));
    }
}
