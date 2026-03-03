package com.mercadopreso.cart.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@With
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String userId;

    @ElementCollection
    private List<Item> itemIdList;

    private String coupon;

    private String freight;
}