package ru.stepup.payments;

import java.util.*;

public class Main {
    static void processPayment(Payable payable) {
        payable.pay(100);
    }
    public static void main(String[] args) {

        TestCase tc1 = new TestCase("Оплата картой");
        tc1.addSteps("1 шаг");
        tc1.addSteps("2 шаг");
        tc1.addSteps("3 шаг");

        TestCase tc2 = new TestCase("Оплата бонусами");
        tc2.addSteps("1 шаг");
        tc2.addSteps("2 шаг");

        TestCase tc3 = new TestCase("Возврат средств");

        List<TestCase> tests = new ArrayList<>();
        tests.add(tc1);
        tests.add(tc2);
        tests.add(tc3);

        for (TestCase tc : tests) {
            try {
                tc.markAsPassed();
                System.out.println(tc.getTitle() + " -> " + tc.getStatus());
            } catch (IllegalStateException e) {
                System.out.println(tc.getTitle() + " -> ошибка: " + e.getMessage());
            }
        }

        System.out.println(tests.get(0).toString());
        System.out.println(tests.get(1).toString());
        System.out.println(tests.get(2).toString());

        System.out.println("Количество тест-кейсов - " + tests.size());
        int countTests = 0;
        for (TestCase tc : tests) {
            countTests += tc.getSteps().size();
        }

        System.out.println("Сумма шагов по всем тест-кейсам - " + countTests);


    }
}