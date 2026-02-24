package com.mercadopreso.checkout.Gateway.Controllers;

import com.mercadopreso.checkout.Domains.Order;
import com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderResponseDto;
import com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderRequestDto;
import com.mercadopreso.checkout.Services.PlaceOrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/fazerPedido")
public class PlaceOrderController {

    private final PlaceOrderService placeOrderService;

    @PostMapping()
    public ResponseEntity<PlaceOrderResponseDto>CreatePlaceOrder(@RequestBody @Valid PlaceOrderRequestDto placeOrderRequestDto) {
        Order order = placeOrderService.createPlaceOrder(placeOrderRequestDto.toCreateOrder());

        return ResponseEntity.status(HttpStatus.CREATED).body(PlaceOrderResponseDto.fromOrder(order));
    }
}
