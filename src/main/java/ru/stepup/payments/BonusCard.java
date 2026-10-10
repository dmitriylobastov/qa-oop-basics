package ru.stepup.payments;

public class BonusCard extends PaymentCard {

    private int bonusPoint;
    public BonusCard(String ownerName, String cardNumber) {
        super(ownerName, cardNumber);
        this.bonusPoint = 0;
    }

    public void addBonus (int points) {
        if (points <=0) {
            throw new IllegalArgumentException("Количество бонусов должно быть больше нуля");
        }
        this.bonusPoint += points;
    }

    public int getBonusPoint (){
        return bonusPoint;
    }

    @Override
    public String toString() {
        return "BonusCard{" +
                "ownerName='" + ownerName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", bonusPoint='" + bonusPoint + '\'' +
                '}';
    }
}
