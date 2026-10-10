package ru.stepup.payments;

public class PaymentMethod implements Payable {

    protected String ownerName;

    public PaymentMethod(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Имя владельца пустое");
        }
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }
    @Override
    public void pay(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма платежа должна быть больше нуля");
        }
        System.out.println("Платеж на сумму " + amount + " через " + getType());
    }

    @Override
    public String getType() {
        return "PaymentMethod";
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "ownerName='" + ownerName + '\'' +
                '}';
    }
}
