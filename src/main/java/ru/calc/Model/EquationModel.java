package ru.calc.Model;

import java.util.Scanner;

public class EquationModel {
    public double calculate(String equation) throws ArithmeticException {
        // Разбиваем строку на числа и операторы с использованием регулярного выражения
        String[] tokens = equation.split("\\s*(?=[-+*/^//])|(?<=[-+*/^//])\\s*");
        double result = Double.parseDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double operand = Double.parseDouble(tokens[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    if (operand == 0) {
                        throw new ArithmeticException("Деление на ноль");
                    }
                    result /= operand;
                    break;
                case "^":
                    result = Math.pow(result, operand);
                    break;
                case "//":
                    result = Math.floorDiv((int) result, (int) operand);
                    break;
                default:
                    throw new IllegalArgumentException("Неверный оператор: " + operator);
            }
        }
        return result;
    }

}
