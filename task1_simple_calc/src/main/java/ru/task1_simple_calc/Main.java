package ru.task1_simple_calc;

import ru.task1_simple_calc.Controller.CalculatorController;
import ru.task1_simple_calc.Model.CalculatorModel;
import ru.task1_simple_calc.View.CalculatorView;

public class Main {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);
        controller.run();
    }
}