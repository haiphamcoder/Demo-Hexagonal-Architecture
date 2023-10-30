package com.hexagonal.demo;

import com.hexagonal.demo.in.ports.PreparingOrder;
import com.hexagonal.demo.order.Order;
import com.hexagonal.demo.out.ports.Orders;

import java.util.UUID;

public class Machine implements PreparingOrder {
    private final Orders orders;

    public Machine(Orders orders) {
        this.orders = orders;
    }

    @Override
    public Order startPreparingOrder(UUID orderId) {
        Order order = orders.findOrderById(orderId);
        return orders.save(order.markPreparing());
    }

    @Override
    public Order finishPreparingOrder(UUID orderId) {
        Order order = orders.findOrderById(orderId);
        return orders.save(order.markReady());
    }
}
