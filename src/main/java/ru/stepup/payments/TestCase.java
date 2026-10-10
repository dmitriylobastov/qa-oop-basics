package ru.stepup.payments;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
    private final String title;
    private final List<String> steps;
    private String status;

    public TestCase(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Имя тест-кейса не может быть пустым");
        }
        this.title = title;
        this.steps = new ArrayList<>();
        this.status = "DRAFT";
    }

    public void addSteps(String steps) {
        if (steps == null || steps.isBlank()) {
            throw new IllegalArgumentException("Шаг не может быть пустым");
        }
        this.steps.add(steps);
    }

    public List<String> getSteps() {
        return new ArrayList<>(steps);
    }

    public void markAsPassed() {
        if (steps.isEmpty()) {
            throw new IllegalStateException("Тест не может быть отмечен пройденным без шагов");
        }
        this.status = "PASSED";
    }

    public String getStatus() {
        return status;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "title='" + title + '\'' +
                ", steps=" + steps +
                ", status='" + status + '\'' +
                '}';
    }
}
