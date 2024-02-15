package ru.calc.Controller;

import ru.calc.Model.EquationModel;
import ru.calc.View.EquationView;

public class EquationController {
    private EquationModel model;
    private EquationView view;

    public EquationController(EquationModel model, EquationView view) {
        this.model = model;
        this.view = view;
    }

    public void processEquation() {
        try {
            String equation = view.getEquationFromUser();
            double result = model.calculate(equation);
            view.displayResult(result);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
