package com.example.interfacegrafica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Coontroller {

    @FXML
    private ChoiceBox<String> operationChoice;

    @FXML
    private TextField number1Field;

    @FXML
    private TextField number2Field;

    @FXML
    private Label resultLabel;

    @FXML
    void calculate(ActionEvent event) {
        try {
            String operation = operationChoice.getValue();
            float num1 = Float.parseFloat(number1Field.getText());
            float num2 = Float.parseFloat(number2Field.getText());

            float result = 0;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        resultLabel.setText("Erro: Divisão por zero");
                        return;
                    }
                    break;
                default:
                    resultLabel.setText("Opção inválida");
                    return;
            }

            resultLabel.setText("O resultado é " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Erro: Digite números válidos");
        }
    }
}

