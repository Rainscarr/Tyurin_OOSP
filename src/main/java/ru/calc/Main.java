package ru.calc;

import ru.calc.Model.EquationModel;
import ru.calc.View.EquationView;
import ru.calc.Controller.EquationController;

public class Main {
    public static void main(String[] args) {
        EquationModel model = new EquationModel();
        EquationView view = new EquationView();
        EquationController controller = new EquationController(model, view);
        controller.processEquation();
    }
}
