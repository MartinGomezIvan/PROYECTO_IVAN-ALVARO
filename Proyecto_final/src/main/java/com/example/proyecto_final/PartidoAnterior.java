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

public class PartidoAnterior {

    @FXML
    private Button BotonVolverPartidosAnteriores;

    @FXML
    private Button ComprarBulls;

    @FXML
    private Button ComprarDallas;

    @FXML
    private Button ComprarNets;

    @FXML
    private Button EstadisticasBulls;

    @FXML
    private Button EstadisticasDallas;

    @FXML
    private Button EstadisticasNets;

    @FXML
    private Label Hora1;

    @FXML
    private Label Hora2;

    @FXML
    private Label Hora3;

    @FXML
    void ComprarEntradaBulls(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Entradas no dsiponibles");
        alert.setContentText("No se pueden vender entradas, el partido fue el 1/6/2023");
        alert.showAndWait();
        //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
        //esta opción, para que el programa no siga
        throw new RuntimeException("");
    }

    @FXML
    void ComprarEntradaDallas(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Entradas no dsiponibles");
        alert.setContentText("No se pueden vender entradas, el partido fue el 2/6/2023");
        alert.showAndWait();
        //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
        //esta opción, para que el programa no siga
        throw new RuntimeException("");
    }

    @FXML
    void ComprarEntradaNets(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Entradas no dsiponibles");
        alert.setContentText("No se pueden vender entradas, el partido fue el 3/6/2023");
        alert.showAndWait();
        //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
        //esta opción, para que el programa no siga
        throw new RuntimeException("");
    }

    @FXML
    void VerEstadisticasBulls(ActionEvent event) {
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("EstadisticasBulls.fxml"));
        try{
            Parent root =fxmlLoader.load();
            Scene scene= new Scene(root);
            Stage stage= new Stage();

            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void VerEstadisticasDallas(ActionEvent event) {
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

    @FXML
    void VerEstadisticasNets(ActionEvent event) {
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

    @FXML
    void VolverPartidosAnteriores(ActionEvent event) {
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
