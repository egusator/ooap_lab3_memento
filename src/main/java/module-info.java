module com.example.ooap_lab3_memento {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ooap_lab3_memento to javafx.fxml;
    exports com.example.ooap_lab3_memento;
}