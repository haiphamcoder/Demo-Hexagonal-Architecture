package com.hexagonal.demo.out.ports;

import com.hexagonal.demo.payment.Payment;

import java.util.UUID;

public interface Payments {
    Payment findPaymentByOrderId(UUID orderId);

    Payment save(Payment payment);
}
