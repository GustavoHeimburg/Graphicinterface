package com.example.interfacegrafica;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller extends Application {

    @FXML
    private Label lblPesoIdeal;
    @FXML
    private TextField txtAltura;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Calculadora de Peso");
        primaryStage.setScene(scene);
        primaryStage.show();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hello-view.fxml"));
            loader.setController(this);
            root.getChildren().add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void calcularPeso() {
        try {
            double altura = Double.parseDouble(txtAltura.getText());
            double pesoIdeal = (altura * 100 - 100) * 0.9;

            lblPesoIdeal.setText("Seu peso ideal é: " + String.format("%.2f", pesoIdeal) + " kg");
        } catch (NumberFormatException ex) {
            lblPesoIdeal.setText("Insira uma altura válida.");
        }
    }

    public void verificarPeso() {
        try {
            double altura = Double.parseDouble(txtAltura.getText());
            double pesoIdeal = (altura * 100 - 100) * 0.9;

            if (pesoIdeal < 0.9 * pesoIdeal) {
                lblPesoIdeal.setText("Você está abaixo do peso ideal. Melhore sua saúde.");
            } else if (pesoIdeal > 1.1 * pesoIdeal) {
                lblPesoIdeal.setText("Você está acima do peso ideal. Melhore sua saúde.");
            } else {
                lblPesoIdeal.setText("Seu peso está OK perante a altura.");
            }
        } catch (NumberFormatException ex) {
            lblPesoIdeal.setText("Insira uma altura válida.");
        }
    }
}
