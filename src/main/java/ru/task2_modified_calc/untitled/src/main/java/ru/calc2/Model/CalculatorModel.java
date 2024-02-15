package ru.calc2.Model;

public class CalculatorModel {
    public double calculate(String equation) {
        try {
            // Проверка на правильное количество скобок
            int bracketCounter = 0;
            for (int i = 0; i < equation.length(); i++) {
                char ch = equation.charAt(i);
                if (ch == '(') {
                    bracketCounter++;
                } else if (ch == ')') {
                    bracketCounter--;
                }
            }
            if (bracketCounter != 0) {
                throw new RuntimeException("Неправильное количество скобок в уравнении.");
            }
            return evaluate(equation);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при вычислении уравнения: " + e.getMessage());
        }
    }

    private double evaluate(String equation) {
        int bracketCounter = 0; // Счетчик скобок

        // Подсчет числа скобок в уравнении
        for (int i = 0; i < equation.length(); i++) {
            char ch = equation.charAt(i);
            if (ch == '(') {
                bracketCounter++;
            } else if (ch == ')') {
                bracketCounter--;
            }
        }

        // Если количество открытых и закрытых скобок не совпадает, выбрасываем исключение
        if (bracketCounter != 0) {
            throw new RuntimeException("Неправильное количество скобок в уравнении.");
        }

        return new Object() {
            int pos = -1, ch;
            char[] chars = equation.toCharArray();

            void nextChar() {
                ch = (++pos < chars.length) ? chars[pos] : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < chars.length) throw new RuntimeException("Неправильный символ: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) x += parseTerm(); // сложение
                    else if (eat('-')) x -= parseTerm(); // вычитание
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) {
                        if (ch == '*') {
                            eat('*');
                            x = Math.pow(x, parseFactor()); // возведение в степень
                        } else {
                            x *= parseFactor(); // умножение
                        }
                    } else if (eat('/')) x /= parseFactor(); // деление
                    else return x;
                }
            }

            double parseFactor() {
                double x;
                int startPos = this.pos;
                if (eat('+')) return parseFactor(); // унарный плюс
                if (eat('-')) x = -parseFactor(); // унарный минус
                else if (eat('(')) { // скобки
                    x = parseExpression();
                    eat(')');
                } else if (Character.isDigit(ch)) { // числа
                    StringBuilder sb = new StringBuilder();
                    while (Character.isDigit(ch)) {
                        sb.append((char) ch);
                        nextChar();
                    }
                    x = Double.parseDouble(sb.toString());
                } else if (eat('e')) { // экспонента
                    eat('x');
                    eat('p');
                    x = Math.exp(parseFactor());
                } else if (eat('l')) { // логарифм
                    eat('o');
                    eat('g');
                    eat('(');
                    x = Math.log(parseFactor()) / Math.log(2);
                    eat(')');
                } else if (eat('!')) { // факториал
                    x = factorial((int) parseFactor());
                } else {
                    throw new RuntimeException("Неправильный символ: " + (char) ch);
                }
                if (eat('^')) {
                    x = Math.pow(x, parseFactor()); // возведение в степень
                }
                return x;
            }

            int factorial(int n) {
                if (n <= 1) return 1;
                return n * factorial(n - 1);
            }
        }.parse();
    }
}
