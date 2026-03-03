package com.mercadopreso.cart.services;

import com.mercadopreso.cart.domain.Cart;
import com.mercadopreso.cart.domain.Item;
import com.mercadopreso.cart.gateways.CartRepository;
import com.mercadopreso.cart.gateways.dto.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public CartDto addItems(List<Item> itemIdList, String userId) {
        List<Item> safeItemIdList = itemIdList == null ? List.of() : itemIdList;

        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> Cart.builder()
                        .userId(userId)
                        .itemIdList(new ArrayList<>())
                        .build());

        if (cart.getItemIdList() == null) {
            cart.setItemIdList(new ArrayList<>());
        }

        cart.getItemIdList().addAll(safeItemIdList);

        Cart saved = cartRepository.save(cart);

        return CartDto.builder()
                .userId(saved.getUserId())
                .itemIdList(saved.getItemIdList())
                .build();
    }
}
