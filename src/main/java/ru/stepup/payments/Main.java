package ru.stepup.payments;

public class Main {
    public static void main(String[] args) {

        PaymentMethod method = new PaymentMethod("Иван");
        method.pay(100);

        PaymentCard card = new PaymentCard("Олег", "1234567890123456");
        card.pay(100);
        System.out.println(card);

        BonusCard bonus = new BonusCard("Вася", "2234567890123456");
        bonus.addBonus(50);
        System.out.println(bonus);

    }
}