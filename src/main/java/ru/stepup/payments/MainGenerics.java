package ru.stepup.payments;

public class MainGenerics {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        System.out.println("Пусто, пока не положили строку? " + stringBox.isEmpty());
        stringBox.set("Строка");
        System.out.println("Пусто, после того как положили строку? " + stringBox.isEmpty());
        System.out.println(stringBox);

        Box<String> stringBox1 = new Box<>("Положил сразу");
        System.out.println(stringBox1);

        Box<Integer> integerBox = new Box<>();
        integerBox.set(10);
        System.out.println(integerBox);

        Box<TestCase> testCaseBox = new Box<>();
        testCaseBox.set(new TestCase("Тест 0"));
        System.out.println(testCaseBox);

//        Box<int> intBox = new Box<>();
//        не сработает, так как дженерик не может быть примитивным типом






    }


}
