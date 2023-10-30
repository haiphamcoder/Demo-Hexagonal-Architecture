package com.hexagonal.demo.out.ports;

import com.hexagonal.demo.order.Order;

import java.util.UUID;

public interface Orders {
    Order findOrderById(UUID orderId);
    Order save(Order order);
    void deletedById(UUID orderId);
}
