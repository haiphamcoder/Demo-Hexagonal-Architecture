package com.hexagonal.demo;

import com.hexagonal.demo.in.ports.Ordering;
import com.hexagonal.demo.order.Order;
import com.hexagonal.demo.out.ports.Orders;
import com.hexagonal.demo.out.ports.Payments;
import com.hexagonal.demo.payment.CreditCard;
import com.hexagonal.demo.payment.Payment;
import com.hexagonal.demo.payment.Receipt;

import java.time.LocalDate;
import java.util.UUID;

public class OrderControl implements Ordering {
    private final Orders orders;
    private final Payments payments;

    public OrderControl(Orders orders, Payments payments) {
        this.orders = orders;
        this.payments = payments;
    }

    @Override
    public Order placeOrder(Order order) {
        return orders.save(order);
    }

    @Override
    public Order updateOrder(UUID orderId, Order order) {
        Order existingOrder = orders.findOrderById(orderId);
        return orders.save(existingOrder.update(order));
    }

    @Override
    public void cancelOrder(UUID orderId) {
        Order order = orders.findOrderById(orderId);
        if (!order.canBeCancelled()) {
            throw new IllegalStateException("Order is already paid and cannot be cancelled");
        }
        orders.deletedById(orderId);
    }

    @Override
    public Order takeOrder(UUID orderId) {
        Order order = orders.findOrderById(orderId);
        return orders.save(order.markTaken());
    }

    @Override
    public Payment payOrder(UUID orderId, CreditCard creditCard) {
        Order order = orders.findOrderById(orderId);
        orders.save(order.markPaid());
        return payments.save(new Payment(orderId, creditCard, LocalDate.now()));
    }

    @Override
    public Receipt readReceipt(UUID orderId) {
        Order order = orders.findOrderById(orderId);
        Payment payment = payments.findPaymentByOrderId(orderId);
        return new Receipt(order.getTotalPrice(), payment.getPaymentDate());
    }
}
