package com.hexagonal.demo.payment;

import java.time.LocalDate;
import java.util.UUID;

public class Payment {
    private UUID orderId;
    private LocalDate paymentDate;
    private CreditCard creditCard;

    public Payment(UUID orderId, CreditCard creditCard, LocalDate paymentDate) {
        this.orderId = orderId;
        this.creditCard = creditCard;
        this.paymentDate = paymentDate;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
