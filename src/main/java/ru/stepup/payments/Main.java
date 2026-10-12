package ru.stepup.payments;

import java.util.*;
import java.util.stream.Collectors;

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

        for (TestCase tc : tests) {
            System.out.println(tc);
        }

        System.out.println("Количество тест-кейсов - " + tests.size());

        int countTests = tests.stream()
                .mapToInt(tc -> tc.getSteps().size())
                .sum();
        System.out.println("Сумма шагов по всем тест-кейсам: " + countTests);

        int countPassedCase = (int) tests.stream()
                .filter(tc -> tc.getStatus().equals("PASSED"))
                .count();
        System.out.println("Количество успешных тест-кейсов: " + countPassedCase);

        List<String>titleTestCase = tests.stream()
                        .map(TestCase::getTitle).collect(Collectors.toList());
        System.out.println("Заголовки тест-кейсов: " + titleTestCase);

        boolean hasNotSteps = tests.stream()
                        .anyMatch(tc -> tc.getSteps().isEmpty());
        System.out.println("Есть тест-кейс без шагов - " + hasNotSteps);

        boolean allHaveSteps = tests.stream()
                .allMatch(tc -> !tc.getSteps().isEmpty());
        System.out.println("У всех тест-кейсов есть шаги - " + allHaveSteps);

        boolean noneWithoutSteps = tests.stream()
                .noneMatch(tc -> tc.getSteps().isEmpty());
        System.out.println("Ни одного тест-кейса без шагов - " + noneWithoutSteps);
    }
}