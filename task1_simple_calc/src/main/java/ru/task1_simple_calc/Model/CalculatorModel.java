package ru.task1_simple_calc.Model;

public class CalculatorModel {
    public double calculate(String equation) {
        try {
            return evaluate(equation);
        } catch (Exception e) {
            System.out.println("Ошибка при вычислении уравнения: " + e.getMessage());
            return Double.NaN; // Возвращаем NaN (Not a Number) в случае ошибки
        }
    }

    private double evaluate(String equation) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < equation.length()) ? equation.charAt(pos) : -1;
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
                if (pos < equation.length()) throw new RuntimeException("Неправильный символ: " + (char) ch);
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
                    if (eat('*')) x *= parseFactor(); // умножение
                    else if (eat('/')) x /= parseFactor(); // деление
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
                } else if (Character.isDigit(ch) || ch == '.') { // числа
                    StringBuilder sb = new StringBuilder();
                    while (Character.isDigit(ch) || ch == '.') {
                        sb.append((char) ch);
                        nextChar();
                    }
                    x = Double.parseDouble(sb.toString());
                } else {
                    throw new RuntimeException("Неправильный символ: " + (char) ch);
                }
                if (eat('^')) x = Math.pow(x, parseFactor()); // возведение в степень
                if (eat('/')) {
                    if (eat('/')) x = (int)x / (int)parseFactor(); // деление без остатка
                    else x /= parseFactor(); // обычное деление
                }
                return x;
            }

        }.parse();
    }
}
