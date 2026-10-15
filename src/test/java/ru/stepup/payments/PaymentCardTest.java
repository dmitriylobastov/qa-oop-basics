package ru.stepup.payments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentCardTest {
    private PaymentCard card;

    @BeforeEach
    void setUp() {
        card = new PaymentCard("1234567890123456", "IVAN IVANOV");
    }

    @Test
    void shouldCreateCardWithZeroBalance() {
        assertThat(card.getBalance())
                .isZero();
    }

    @Test
    void shouldTopUpBalance() {
        card.topUp(1000);
        assertThat(card.getBalance())
                .isEqualTo(1000);
    }

    @Test
    void shouldWithdrawFromBalance() {
        card.topUp(1000);
        card.withdraw(300);
        assertThat(card.getBalance())
                .isEqualTo(700);
    }

    @Test
    void shouldAddUpMultipleTopUps() {
        card.topUp(100);
        card.topUp(200);
        assertThat(card.getBalance())
                .isEqualTo(300);
    }

    @Test
    void shouldThrowWhenTopUpNegative() {
        assertThatThrownBy(() -> card.topUp(-100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Сумма пополнения должна быть больше нуля");
    }

    @Test
    void shouldThrowWhenTopUpZero() {
        assertThatThrownBy(() -> card.topUp(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Сумма пополнения должна быть больше нуля");
    }

    @Test
    void shouldThrowWhenWithdrawMoreThanBalance() {
        card.topUp(500);
        assertThatThrownBy(() -> card.withdraw(1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Сумма списания больше баланса");
    }

    @Test
    void shouldThrowWhenCreateCardWithInvalidNumber() {
        assertThatThrownBy(() -> new PaymentCard("123", "IVAN"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Номер карты должен содержать 16 цифр");
    }

    @Test
    void shouldKeepBalanceAfterFailedWithdraw() {
        card.topUp(500);
        assertThatThrownBy(() -> card.withdraw(1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Сумма списания больше баланса");
        assertThat(card.getBalance()).isEqualTo(500);
    }


}
