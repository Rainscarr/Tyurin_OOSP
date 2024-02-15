package ru.calc2.Controller;

import ru.calc2.Model.CalculatorModel;
import ru.calc2.View.CalculatorView;

public class CalculatorController {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        String equation = view.getInputEquation();
        double result = model.calculate(equation);
        view.displayResult(result);
    }
}