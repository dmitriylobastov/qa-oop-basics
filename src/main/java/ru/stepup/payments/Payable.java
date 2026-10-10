package ru.stepup.payments;

public interface Payable {
    void pay(double amount);
    String getType();
}
