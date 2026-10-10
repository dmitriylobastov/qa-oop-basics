package ru.stepup.payments;

public class TestCase {
    private String title;          // private = снаружи не видно
    private String status;         // статус меняем только через метод
    private int stepsCount;        // шаги только добавляем, не присваиваем вручную

    public TestCase(String title) {
        setTitle(title);           // конструктор тоже идёт через валидацию
        this.status = "DRAFT";     // новый тест-кейс всегда черновик
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название тест-кейса не может быть пустым");
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addStep() {
        this.stepsCount++;         // снаружи нельзя поставить -5, только +1
    }

    public int getStepsCount() {
        return stepsCount;
    }

    public void markAsPassed() {
        if (stepsCount == 0) {
            throw new IllegalStateException("Нельзя завершить тест без шагов");
        }
        this.status = "PASSED";
    }

    public String getStatus() {
        return status;
    }
}
