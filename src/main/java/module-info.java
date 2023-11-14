module com.example.interfacegrafica {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.interfacegrafica to javafx.fxml;
    exports com.example.interfacegrafica;
}