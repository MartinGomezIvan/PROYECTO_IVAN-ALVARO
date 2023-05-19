package com.example.proyecto_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ProximoPartido {

    @FXML
    private Button BotonVolverPartidosHoy;

    @FXML
    private Button ComprarCavaliers;

    @FXML
    private Button ComprarWarriors;

    @FXML
    private Button ComprarWolves;

    @FXML
    private Label Hora1;

    @FXML
    private Label Hora2;

    @FXML
    private Label Hora3;

    @FXML
    void ComprarEntradaCavaliers(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Entradas no dsiponibles");
        alert.setContentText("Las entradas saldrán a la venta el 22/6/2023");
        alert.showAndWait();
        //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
        //esta opción, para que el programa no siga
        throw new RuntimeException("");
    }

    @FXML
    void ComprarEntradaWarriors(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Entradas no dsiponibles");
        alert.setContentText("Las entradas saldrán a la venta el 20/6/2023");
        alert.showAndWait();
        //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
        //esta opción, para que el programa no siga
        throw new RuntimeException("");
    }

    @FXML
    void ComprarEntradaWolves(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Entradas no dsiponibles");
        alert.setContentText("Las entradas saldrán a la venta el 21/6/2023");
        alert.showAndWait();
        //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
        //esta opción, para que el programa no siga
        throw new RuntimeException("");
    }

    @FXML
    void VolverPartidosHoy(ActionEvent event) {
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("hello-view.fxml"));
        try{
            Parent root =fxmlLoader.load();
            HelloController controlador=fxmlLoader.getController();
            Scene scene= new Scene(root);
            Stage stage= new Stage();

            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}
