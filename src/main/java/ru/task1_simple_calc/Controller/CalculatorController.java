package ru.task1_simple_calc.Controller;

import ru.task1_simple_calc.Model.CalculatorModel;
import ru.task1_simple_calc.View.CalculatorView;

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
