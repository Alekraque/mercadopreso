package com.mercadopreso.order.Domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "items")
@With
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    private String id;

    @Column(nullable = false)
    private String sku;

    @Column(nullable = false)
    private BigDecimal price;
}

