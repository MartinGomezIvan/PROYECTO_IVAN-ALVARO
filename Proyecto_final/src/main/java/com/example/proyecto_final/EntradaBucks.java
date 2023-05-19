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
import java.util.ResourceBundle;

public class EntradaBucks implements Initializable {

    @FXML
    private Button BotonCalcularTotal;
    @FXML
    private Button BotonEnviar;
    @FXML
    private Button BotonVolver;

    @FXML
    private TextField EscribirAsientos;

    @FXML
    private TextField EscribirFila;

    @FXML
    private TextField EscribirNumEntradas;

    @FXML
    private RadioButton NormalSeleccionado;

    @FXML
    private TextArea PonerCorreo;

    @FXML
    private TextArea TextoTotal;

    @FXML
    private RadioButton VIPSeleccionado;

    @FXML
    private ChoiceBox<String> choiceboxUbicacion;

    @FXML
    private ToggleGroup entrada;
    String [] Ubicacion= {"Fondo Norte","Fondo Sur","Tribuna Este","Tribuna Oeste"};
    String precioFinal="";
    @FXML
    void PulsarBotonCalcular(ActionEvent event) {
        int precio=0;
        int entradas = 0;
        if (EscribirNumEntradas.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe seleccionar una opción en Nºentradas");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            entradas = Integer.parseInt(EscribirNumEntradas.getText());;
        }
        if (!NormalSeleccionado.isSelected() && !VIPSeleccionado.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe pulsar una opción en las entradas");
            alert.showAndWait();

            throw new RuntimeException("");
        } else if(NormalSeleccionado.isSelected()){
            precio=(entradas*10);

        }else if(VIPSeleccionado.isSelected()){
            precio=(entradas*15);
        }
        precioFinal = precio + "";
        TextoTotal.setText(precioFinal+"€");

    }
    @FXML
    void PulsarBotonEnviar(ActionEvent event) {
        String correo="";
        String fila="";
        String asientos="";
        if (choiceboxUbicacion.getValue()==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe seleccionar una opción en Ubicación");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");
        } else {
            System.out.println("");
        }

            if (EscribirFila.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error en datos");
                alert.setContentText("Debe seleccionar una opción en Fila");
                alert.showAndWait();
                //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
                //esta opción, para que el programa no siga
                throw new RuntimeException("");

            } else {
                fila = EscribirFila.getText();
            }
            if (EscribirAsientos.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error en datos");
                alert.setContentText("Debe seleccionar una opción en Asientos");
                alert.showAndWait();
                //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
                //esta opción, para que el programa no siga
                throw new RuntimeException("");

            } else {
                asientos = EscribirAsientos.getText();
            }

            if (PonerCorreo.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error en datos");
                alert.setContentText("Debe seleccionar una opción en Correo");
                alert.showAndWait();
                //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
                //esta opción, para que el programa no siga
                throw new RuntimeException("");

            } else {
                correo = PonerCorreo.getText();
            }
        if (TextoTotal.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe calcular el total");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            System.out.println();
        }



        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion de datos");
        alert.setContentText("Se le enviará una factura a: \nCorreo: "+correo+ "\nCon la siguinete información"+ " \nUbicación: "+choiceboxUbicacion.getValue()+" \nFila: "+fila+ " \nAsientos: "+asientos+ " \nPrecio: "+precioFinal+"€"+"\nPartido: Bucks-Sixers");
        alert.showAndWait();
    }

    @FXML
    void PulsarBotonVolver(ActionEvent event) {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            choiceboxUbicacion.getItems().addAll(Ubicacion);



    }
}








