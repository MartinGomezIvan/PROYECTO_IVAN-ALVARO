package com.example.proyecto_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button BotonInicioPartidos;

    @FXML
    private Button BotonPartidosAnteriores;

    @FXML
    private Button BotonProximoPartido;

    @FXML
    private Button ComprarBucks;

    @FXML
    private Button ComprarLakers;

    @FXML
    private Button ComprarMiami;

    @FXML
    private Label Hora1;

    @FXML
    private Label Hora2;

    @FXML
    private Label Hora3;


    @FXML
    void ComprarEntradaBucks(ActionEvent event) {
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("EntradaBucks.fxml"));
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
    void ComprarEntradaLakers(ActionEvent event) {
        FXMLLoader fxmlLoaderLakers= new FXMLLoader(getClass().getResource("EntradaLakers.fxml"));
        try{
            Parent root =fxmlLoaderLakers.load();
            Scene scene= new Scene(root);
            Stage stage= new Stage();

            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void ComprarEntradaMiami(ActionEvent event) {
        FXMLLoader fxmlLoaderMiami= new FXMLLoader(getClass().getResource("EntradaMiami.fxml"));
        try{
            Parent root =fxmlLoaderMiami.load();
            Scene scene= new Scene(root);
            Stage stage= new Stage();

            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void PartidosAnteriores(ActionEvent event) {
        FXMLLoader fxmlLoaderAnteriores= new FXMLLoader(getClass().getResource("PartidoAnterior.fxml"));
        try{
            Parent root =fxmlLoaderAnteriores.load();
            Scene scene= new Scene(root);
            Stage stage= new Stage();

            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    void ProximosPartidos(ActionEvent event) {
        FXMLLoader fxmlLoaderProximos= new FXMLLoader(getClass().getResource("ProximoPartido.fxml"));
        try{
            Parent root =fxmlLoaderProximos.load();
            Scene scene= new Scene(root);
            Stage stage= new Stage();

            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void VolverInicioPartidos(ActionEvent event) {

    }

}



