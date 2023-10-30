package com.hexagonal.demo.payment;

import java.time.Month;
import java.time.Year;

public class CreditCard {
    private String cardHolderName;
    private String cardNumber;
    private Month expiryMonth;
    private Year expiryYear;

    public CreditCard(String cardHolderName, String cardNumber, Month expiryMonth, Year expiryYear) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Month getExpiryMonth() {
        return expiryMonth;
    }

    public Year getExpiryYear() {
        return expiryYear;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpiryMonth(Month expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public void setExpiryYear(Year expiryYear) {
        this.expiryYear = expiryYear;
    }
}
