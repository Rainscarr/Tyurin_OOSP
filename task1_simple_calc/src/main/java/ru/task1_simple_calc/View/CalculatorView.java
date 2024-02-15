package ru.task1_simple_calc.View;

import java.util.Scanner;

// View
public class CalculatorView {
    public void displayResult(double result) {
        System.out.println("Результат: " + result);
    }

    public String getInputEquation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите уравнение: ");
        return scanner.nextLine();
    }
}