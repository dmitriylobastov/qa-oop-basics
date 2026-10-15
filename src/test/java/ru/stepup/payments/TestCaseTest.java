package ru.stepup.payments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestCaseTest {

    private TestCase tc;

    @BeforeEach
    void setUp() {
        tc = new TestCase("Оплата картой");
        tc.addStep("1 шаг");
        tc.addStep("2 шаг");
        tc.addStep("3 шаг");
    }

    @Test
    void shouldReturnTitle() {
        assertThat(tc.getTitle())
                .isEqualTo("Оплата картой")
                .startsWith("Оплата");
    }

    @Test
    void shouldContainAllSteps() {
        assertThat(tc.getSteps())
                .hasSize(3)
                .contains("1 шаг", "2 шаг");
    }
}
