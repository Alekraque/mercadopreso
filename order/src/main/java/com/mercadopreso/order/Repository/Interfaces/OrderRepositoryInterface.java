package com.mercadopreso.order.Repository.Interfaces;

import com.mercadopreso.order.Domains.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryInterface extends JpaRepository<Order, String> {
}
