package ru.stepup.payments;

public class PaymentCard extends PaymentMethod {

    protected String cardNumber;
//    protected String holderName;
    protected int balance;
    public PaymentCard(String cardNumber,String ownerName) {
        super(ownerName);
        if (cardNumber == null || !cardNumber.matches("\\d{16}")) {
            throw new IllegalArgumentException("Номер карты должен содержать 16 цифр");
        }
        this.cardNumber = cardNumber;
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Имя держателя карты не должно быть пустое");
        }
        this.ownerName = ownerName;
        this.balance = 0;
    }


    @Override
    public String getType() {
        return "PaymentCard";
    }

    @Override
    public String toString() {
        return "PaymentCard{" +
                "ownerName='" + ownerName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
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
//    public String getHolderName() {
//        return holderName;
//    }
    public double getBalance() {
        return balance;
    }
}
