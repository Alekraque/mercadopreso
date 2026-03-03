package com.mercadopreso.cart.gateways;

import com.mercadopreso.cart.gateways.dto.AddItemsRequestDto;
import com.mercadopreso.cart.gateways.dto.CartDto;
import com.mercadopreso.cart.services.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping()
    public ResponseEntity<CartDto> postItems(@Valid @RequestBody AddItemsRequestDto request) {
        CartDto cartDto = cartService.addItems(
                request.getItemIdList(),
                request.getUserId()
        );
        return ResponseEntity.ok(cartDto);
    }
}
