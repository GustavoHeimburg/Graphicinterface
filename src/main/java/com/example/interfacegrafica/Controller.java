package com.example.interfacegrafica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller extends Application {
//
    @Override
    public void start(Stage primaryStage) {
        Label lblAltura = new Label("Altura (em metros):");
        TextField txtAltura = new TextField();
        Label lblPesoIdeal = new Label();
        txtAltura.setOnKeyReleased(e -> {
            try {
                double altura = Double.parseDouble(txtAltura.getText());
                double pesoIdeal = (altura * 100 - 100) * 0.9;

                lblPesoIdeal.setText("Seu peso ideal é: " + String.format("%.2f", pesoIdeal) + " kg");
            } catch (NumberFormatException ex) {
                lblPesoIdeal.setText("Insira uma altura válida.");
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(lblAltura, txtAltura, lblPesoIdeal);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Calculadora de Peso");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
