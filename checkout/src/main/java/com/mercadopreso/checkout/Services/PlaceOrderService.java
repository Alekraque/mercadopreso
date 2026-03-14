package com.mercadopreso.checkout.Services;

import com.mercadopreso.checkout.Domains.Item;
import com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto.CartDto;
import com.mercadopreso.checkout.Gateway.client.order.OrderClient;
import com.mercadopreso.checkout.Gateway.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PlaceOrderService {
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    private final OrderClient orderClient;

    public CartDto placeOrder(CartDto cart) {
        List<Item> items = cart.getItems();
        BigDecimal itemsTotal = calculateItemsTotal(items);
        BigDecimal freight = safeBigDecimal(cart.getFreight());
        BigDecimal discount = calculateDiscount(cart.getCoupon(), itemsTotal, freight);
        BigDecimal finalPrice = itemsTotal.add(freight).subtract(discount);
        if (finalPrice.compareTo(BigDecimal.ZERO) < 0) {
            finalPrice = BigDecimal.ZERO;
        }

        orderClient.sendOrder(OrderMapper.fromCart(cart, finalPrice));
        return cart;
    }

    private BigDecimal calculateItemsTotal(List<Item> items) {
        if (items == null || items.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return items.stream()
                .map(Item::getPrice)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateDiscount(String coupon, BigDecimal itemsTotal, BigDecimal freight) {
        if (coupon == null || coupon.isBlank()) {
            return BigDecimal.ZERO;
        }

        String normalized = coupon.trim().toUpperCase();
        if (normalized.equals("FRETE_GRATIS") || normalized.equals("FREIGHT_FREE")) {
            return freight;
        }

        if (normalized.endsWith("%")) {
            String percentText = normalized.substring(0, normalized.length() - 1).trim();
            try {
                BigDecimal percent = new BigDecimal(percentText);
                if (percent.compareTo(BigDecimal.ZERO) <= 0) {
                    return BigDecimal.ZERO;
                }
                return itemsTotal.multiply(percent).divide(HUNDRED, 2, RoundingMode.HALF_UP);
            } catch (NumberFormatException ignored) {
                return BigDecimal.ZERO;
            }
        }

        try {
            BigDecimal absolute = new BigDecimal(normalized.replace(",", "."));
            return absolute.compareTo(BigDecimal.ZERO) > 0 ? absolute : BigDecimal.ZERO;
        } catch (NumberFormatException ignored) {
            return BigDecimal.ZERO;
        }
    }

    private BigDecimal safeBigDecimal(BigDecimal value) {
        return value == null ? BigDecimal.ZERO : value;
    }
}
