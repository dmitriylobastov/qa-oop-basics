package ru.stepup.payments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentCardTest {
    private PaymentCard card;

    @BeforeEach
    void setUp() {
        card = new PaymentCard("1234567890123456", "IVAN IVANOV");
    }

    @Test
    void shouldCreateCardWithZeroBalance() {
        assertEquals(0, card.getBalance());
    }

    @Test
    void shouldTopUpBalance() {
        card.topUp(1000);
        assertEquals(1000, card.getBalance());
    }

    @Test
    void shouldWithdrawFromBalance() {
        card.topUp(1000);
        card.withdraw(300);
        assertEquals(700, card.getBalance());
    }

    @Test
    void shouldAddUpMultipleTopUps() {
        card.topUp(100);
        card.topUp(200);
        assertEquals(300, card.getBalance());
    }

    @Test
    void shouldThrowWhenTopUpNegative() {
        assertThrows(IllegalArgumentException.class, () -> card.topUp(-100));
    }

    @Test
    void shouldThrowWhenTopUpZero() {
        assertThrows(IllegalArgumentException.class, () -> card.topUp(0));
    }

    @Test
    void shouldThrowWhenWithdrawMoreThanBalance() {
        card.topUp(500);
        assertThrows(IllegalArgumentException.class, () -> card.withdraw(1000));
    }

    @Test
    void shouldThrowWhenCreateCardWithInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> new PaymentCard("123", "IVAN"));
    }

    @Test
    void shouldKeepBalanceAfterFailedWithdraw() {
        card.topUp(500);
        assertThrows(IllegalArgumentException.class, () -> card.withdraw(1000));
        assertEquals(500, card.getBalance());
    }

}
