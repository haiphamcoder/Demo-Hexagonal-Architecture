package com.hexagonal.demo.in.ports;

import com.hexagonal.demo.order.Order;

import java.util.UUID;

public interface PreparingOrder {
    Order startPreparingOrder(UUID orderId);
    Order finishPreparingOrder(UUID orderId);
}
