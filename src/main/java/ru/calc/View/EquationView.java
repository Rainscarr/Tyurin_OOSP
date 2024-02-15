package ru.calc.View;

import java.util.Scanner;

public class EquationView {
    private Scanner scanner;

    public EquationView() {
        scanner = new Scanner(System.in);
    }

    public void displayResult(double result) {
        System.out.println("Результат: " + result);
    }

    public String getEquationFromUser() {
        System.out.println("Введите математическое выражение:");
        return scanner.nextLine();
    }
}
