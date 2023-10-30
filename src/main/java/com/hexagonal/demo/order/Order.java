package com.hexagonal.demo.order;

import com.hexagonal.demo.shared.Status;

import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id = UUID.randomUUID();
    private final List<Product> products;
    private Status status = Status.PAYMENT_EXPECTED;

    public Order(List<Product> products) {
        this.products = products;
    }

    public Order(UUID id, List<Product> products, Status status) {
        this.id = id;
        this.products = products;
        this.status = status;
    }

    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public UUID getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean canBeCancelled() {
        return status == Status.PAYMENT_EXPECTED;
    }

    public Order update(Order order) {
        if (this.status == Status.PAID) {
            throw new IllegalStateException("Order is already paid!");
        }
        return new Order(this.id, order.getProducts(), this.status);
    }

    public Order markPaid() {
        if (this.status != Status.PAYMENT_EXPECTED) {
            throw new IllegalStateException("Order is not ready to be paid!");
        }
        this.status = Status.PAID;
        return this;
    }

    public Order markPreparing() {
        if (this.status != Status.PAID) {
            throw new IllegalStateException("Order is not ready to be preparing!");
        }
        this.status = Status.PREPARING;
        return this;
    }

    public Order markReady() {
        if (this.status != Status.PREPARING) {
            throw new IllegalStateException("Order is not being ready!");
        }
        this.status = Status.READY;
        return this;
    }

    public Order markTaken() {
        if (this.status != Status.READY) {
            throw new IllegalStateException("Order is not ready");
        }
        this.status = Status.TAKEN;
        return this;
    }
}
