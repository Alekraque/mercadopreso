package com.mercadopreso.checkout.Domains;


import lombok.*;

@With
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private String userId;
}
