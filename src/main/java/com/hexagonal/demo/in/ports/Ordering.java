package com.hexagonal.demo.in.ports;

import com.hexagonal.demo.order.Order;
import com.hexagonal.demo.payment.CreditCard;
import com.hexagonal.demo.payment.Payment;
import com.hexagonal.demo.payment.Receipt;

import java.util.UUID;

public interface Ordering {
    Order placeOrder(Order order);

    Order updateOrder(UUID orderId, Order order);

    void cancelOrder(UUID orderId);

    Order takeOrder(UUID orderId);

    Payment payOrder(UUID orderId, CreditCard creditCard);

    Receipt readReceipt(UUID orderId);
}
