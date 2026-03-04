package com.mercadopreso.order.Domains;

import com.mercadopreso.order.Domains.Enums.OrderStatus;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private String userId;
    private List<Item> items;
    private BigDecimal precoFinal;
    private OrderStatus status;
    private String endereco;
    private String paymentId;
}