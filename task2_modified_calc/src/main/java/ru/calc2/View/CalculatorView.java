package ru.calc2.View;

import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner;

    public CalculatorView() {
        scanner = new Scanner(System.in);
    }

    public void displayResult(double result) {
        System.out.println("Результат: " + result);
    }

    public String getInputEquation() {
        System.out.print("Введите уравнение: ");
        return scanner.nextLine();
    }

    public void displayErrorMessage(String errorMessage) {
        System.out.println("Ошибка: " + errorMessage);
    }
}
