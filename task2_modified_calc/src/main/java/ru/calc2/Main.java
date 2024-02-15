package ru.calc2;

import ru.calc2.Controller.CalculatorController;
import ru.calc2.Model.CalculatorModel;
import ru.calc2.View.CalculatorView;

public class Main {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);
        controller.run();
    }
}
