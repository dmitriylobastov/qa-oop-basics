package ru.stepup.payments;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        TestCase tc1 = new TestCase("Оплата картой");
        tc1.addStep("1 шаг");
        tc1.addStep("2 шаг");
        tc1.addStep("3 шаг");

        TestCase tc2 = new TestCase("Оплата бонусами");
        tc2.addStep("1 шаг");
        tc2.addStep("2 шаг");

        TestCase tc3 = new TestCase("Возврат средств");

        List<TestCase> tests = new ArrayList<>();
        tests.add(tc1);
        tests.add(tc2);
        tests.add(tc3);

        if (tests.isEmpty()) {
            System.out.println("Список кейсов пуст");
            return;
        }

        for (TestCase tc : tests) {
            try {
                tc.markAsPassed();
                System.out.println(tc.getTitle() + " -> " + tc.getStatus());
            } catch (IllegalStateException e) {
                System.out.println(tc.getTitle() + " -> ошибка: " + e.getMessage());
            }
        }

        int countTests = 0;
        for (TestCase tc : tests) {
            System.out.println(tc);
            countTests += tc.getSteps().size();
        }
        System.out.println("Количество тест-кейсов - " + tests.size());
        System.out.println("Сумма шагов по всем тест-кейсам - " + countTests);

    }
}