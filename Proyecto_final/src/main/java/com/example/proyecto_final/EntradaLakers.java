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

public class EntradaLakers implements Initializable {

    @FXML
    private Button BotonCalcularTotalL;

    @FXML
    private Button BotonEnviarL;

    @FXML
    private Button BotonVolverL;

    @FXML
    private TextField EscribirAsientosL;

    @FXML
    private TextField EscribirFilaL;

    @FXML
    private TextField EscribirNumEntradasL;

    @FXML
    private RadioButton NormalSeleccionadoL;

    @FXML
    private TextArea PonerCorreoL;

    @FXML
    private TextArea TextoTotalL;

    @FXML
    private RadioButton VIPSeleccionadoL;

    @FXML
    private ChoiceBox<String> choiceboxUbicacionL;

    @FXML
    private ToggleGroup entradaL;
    String [] Ubicacion= {"Fondo Norte","Fondo Sur","Tribuna Este","Tribuna Oeste"};
    String precioFinal="";
    @FXML
    void PulsarBotonCalcularL(ActionEvent event) {
        int precio=0;
        int entradas = 0;
        if (EscribirNumEntradasL.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe seleccionar una opción en Nºentradas");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            entradas = Integer.parseInt(EscribirNumEntradasL.getText());;
        }
        if (!NormalSeleccionadoL.isSelected() && !VIPSeleccionadoL.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe pulsar una opción en las entradas");
            alert.showAndWait();

            throw new RuntimeException("");
        } else if(NormalSeleccionadoL.isSelected()){
            precio=(entradas*10);

        }else if(VIPSeleccionadoL.isSelected()){
            precio=(entradas*15);
        }
        precioFinal = precio + "";
        TextoTotalL.setText(precioFinal+"€");
    }

    @FXML
    void PulsarBotonEnviar(ActionEvent event) {
        String correo="";
        String fila="";
        String asientos="";
        if (choiceboxUbicacionL.getValue()==null) {
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

        if (EscribirFilaL.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe seleccionar una opción en Fila");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            fila = EscribirFilaL.getText();
        }
        if (EscribirAsientosL.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe seleccionar una opción en Asientos");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            asientos = EscribirAsientosL.getText();
        }

        if (PonerCorreoL.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe seleccionar una opción en Correo");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            correo = PonerCorreoL.getText();
        }
        if (TextoTotalL.getText().isEmpty()) {
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
        alert.setContentText("Se le enviará una factura a: \nCorreo: "+correo+ "\nCon la siguinete información"+ " \nUbicación: "+choiceboxUbicacionL.getValue()+" \nFila: "+fila+ " \nAsientos: "+asientos+ " \nPrecio: "+precioFinal+"€"+"\nPartido: Lakers-Suns");
        alert.showAndWait();
    }

    @FXML
    void PulsarBotonVolverL(ActionEvent event) {
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
        choiceboxUbicacionL.getItems().addAll(Ubicacion);
    }
}
