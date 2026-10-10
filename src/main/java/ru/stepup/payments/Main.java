package ru.stepup.payments;

public class Main {
    static void processPayment(Payable payable) {
        payable.pay(100);
    }
    public static void main(String[] args) {
        PaymentMethod method = new PaymentMethod("Иван");
        processPayment(method);
        System.out.println(method);

        PaymentCard card = new PaymentCard("Олег", "1234567890123456");
        processPayment(card);
        System.out.println(card);

        BonusCard bonus = new BonusCard("Вася", "2234567890123456");
        bonus.addBonus(50);
        processPayment(bonus);
        System.out.println(bonus);
    }
}