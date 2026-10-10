package ru.stepup.payments;

public class PaymentCardOld {
    private String cardNumber;
    private String holderName;
    private double balance;
    public PaymentCardOld(String cardNumber, String holderName) {
        if (cardNumber == null || !cardNumber.matches("\\d{16}")) {
            throw new IllegalArgumentException("Номер карты должен содержать 16 цифр");
        }
        this.cardNumber = cardNumber;
        if (holderName == null || holderName.isBlank()) {
            throw new IllegalArgumentException("Имя держателя карты не должно быть пустое");
        }
        this.holderName = holderName;
        this.balance = 0;
    }
    @Override
    public String toString() {
        return "PaymentCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                '}';
    }

    private void validateAmount(double amount, String operation) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма " + operation + " должна быть больше нуля");
        }
    }
    public void topUp(double amount) {
        validateAmount(amount, "пополнения");
        this.balance += amount;
    }
    public void withdraw (double amount) {
        validateAmount(amount, "списания");
        if (amount > balance) {
            throw new IllegalArgumentException("Сумма списания больше баланса");
        }
        this.balance -= amount;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public String getHolderName() {
        return holderName;
    }
    public double getBalance() {
        return balance;
    }
}
