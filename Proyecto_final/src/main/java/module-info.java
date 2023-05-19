module com.example.proyecto_final {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.proyecto_final to javafx.fxml;
    exports com.example.proyecto_final;
}