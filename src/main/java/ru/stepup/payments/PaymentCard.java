package ru.stepup.payments;

public class PaymentCard extends PaymentMethod {

    protected String cardNumber;
    public PaymentCard(String ownerName, String cardNumber) {
        super(ownerName);
        if (cardNumber == null || !cardNumber.matches("\\d{16}")) {
            throw new IllegalArgumentException("Номер карты должен содержать 16 цифр");
        }
        this.cardNumber = cardNumber;
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
}
