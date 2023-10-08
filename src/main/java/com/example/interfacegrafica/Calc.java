package CursoJava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class calc extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("calc.fxml"));
        Scene scene = new Scene(root, 400, 250);
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
    }
}
