package com.example.proyecto_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Pestaña1Torneo implements Initializable {

    @FXML
    private Button BotonContinuar;
    @FXML
    private Button BotonFechasEscogidas;
    @FXML
    private Button BotonInicio;

    @FXML
    private TextField EscribirCiudad;

    @FXML
    private TextField EscribirEquipos;

    @FXML
    private TextField EscribirPresupuesto;
    @FXML
    private TextField EscribirTelefono;
    @FXML
    private DatePicker Fechas;

    @FXML
    private TextField PonerLocal;

    @FXML
    private TextField PonerPremio;

    @FXML
    private TextField PonerVisitante;

    @FXML
    private ChoiceBox<String> VerSugerencias;
    ArrayList Torneo= new ArrayList();

String[] Sugerencias={"Local:Rojo-Visitante:Blanco","Local:Verde-Visitante:Amarillo","Local:Azul-Visitante:Rosa","Local:Marrón-Visitante:Naranja"};

    @FXML
    void PulsarBotonContinuar(ActionEvent event) {
        /*Torneo.add(LocalDate.of(2023, 2, 1));
        Torneo.add(LocalDate.of(2023, 7, 24));
        Torneo.add(LocalDate.of(2023, 12, 6));
        Torneo.add(LocalDate.of(2024, 3, 18));
        Torneo.add(LocalDate.of(2024, 6, 30));*/
        String Presuspuesto="";
        String Equipos="";
        String fecha1="";
        String Ciudad="";
        String Premios="";
        String Telefono="";
        String ObtenerSugerencias="";
        String ObtenerLocal="";
        String ObtenerVisitante="";
        if (EscribirPresupuesto.getText()==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe escribir el presupuesto");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");
        } else {
            Presuspuesto=EscribirPresupuesto.getText();
        }

        if (EscribirEquipos.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe escribir el número de equipos");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            Equipos= EscribirEquipos.getText();
        }
        if (EscribirCiudad.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe seleccionar una opción en ciudad");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            Ciudad = EscribirCiudad.getText();
        }
        if (EscribirTelefono.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debes escribir tu teléfono");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            Telefono = EscribirTelefono.getText();
        }


        LocalDate selectedDate = Fechas.getValue();

        if (selectedDate != null && Torneo.contains(selectedDate)) {
            Alert alert1=new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Error en datos");
            alert1.setContentText("fecha repetida");
            alert1.showAndWait();
            throw new RuntimeException("");
        } else {
            System.out.println("");
        }
        if (VerSugerencias.getValue()==null && PonerLocal.getText().isEmpty() && PonerVisitante.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe seleccionar una opción equipación");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");
        } else if(VerSugerencias.getValue()!=null) {
            ObtenerSugerencias=VerSugerencias.getValue();
        } else if (!PonerLocal.getText().isEmpty() && !PonerVisitante.getText().isEmpty()) {
            ObtenerLocal=PonerLocal.getText();
            ObtenerVisitante=PonerVisitante.getText();
        }

        if (PonerPremio.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe escribir un premio");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            Premios=PonerPremio.getText();
        }
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion de datos");
        alert.setContentText("Nos pondremos en contacto con el teléfono: "+Telefono+" para ultimar los detalles");
        alert.showAndWait();

    }


    @FXML
    void PulsarBotonInicio(ActionEvent event) {
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("inicio.fxml"));
        try {
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            // Obtener una referencia al Stage de la ventana actual
            Stage currentStage = (Stage) BotonContinuar.getScene().getWindow();
            // Cerrar la ventana actual
            currentStage.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void PulsarbotonFechasEscogidas(ActionEvent event) {

        LocalDate fecha1 = LocalDate.of(2023, 2, 1);
        LocalDate fecha2 = LocalDate.of(2023, 7, 24);
        LocalDate fecha3 = LocalDate.of(2023, 12, 6);
        LocalDate fecha4 = LocalDate.of(2024, 3, 18);
        LocalDate fecha5 = LocalDate.of(2024, 6, 30);

        if (!Torneo.contains(fecha1)) {
            Torneo.add(fecha1);
        }
        if (!Torneo.contains(fecha2)) {
            Torneo.add(fecha2);
        }
        if (!Torneo.contains(fecha3)) {
            Torneo.add(fecha3);
        }
        if (!Torneo.contains(fecha4)) {
            Torneo.add(fecha4);
        }
        if (!Torneo.contains(fecha5)) {
            Torneo.add(fecha5);
        }
                Iterator Recorrer = Torneo.iterator();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informacion de datos");
                alert.setContentText("Fechas no disponibles: \n:" + Torneo.toString());
                alert.showAndWait();
                while (Recorrer.hasNext()) {
                    alert.setContentText("\n" + Recorrer.next());
                }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        VerSugerencias.getItems().addAll(Sugerencias);
    }



}




