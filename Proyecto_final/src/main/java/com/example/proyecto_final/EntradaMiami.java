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

public class EntradaMiami implements Initializable {

    @FXML
    private Button BotonCalcularTotalM;

    @FXML
    private Button BotonEnviarM;

    @FXML
    private Button BotonVolverM;

    @FXML
    private TextField EscribirAsientosM;

    @FXML
    private TextField EscribirFilaM;

    @FXML
    private TextField EscribirNumEntradasM;

    @FXML
    private RadioButton NormalSeleccionadoM;

    @FXML
    private TextArea PonerCorreoM;

    @FXML
    private TextArea TextoTotalM;

    @FXML
    private RadioButton VIPSeleccionadoM;

    @FXML
    private ChoiceBox<String> choiceboxUbicacionM;

    @FXML
    private ToggleGroup entradaM;
    String [] Ubicacion= {"Fondo Norte","Fondo Sur","Tribuna Este","Tribuna Oeste"};
    String precioFinal="";
    @FXML
    void PulsarBotonCalcularM(ActionEvent event) {
        int precio=0;
        int entradas = 0;
        if (EscribirNumEntradasM.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe seleccionar una opción en Nºentradas");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            entradas = Integer.parseInt(EscribirNumEntradasM.getText());;
        }
        if (!NormalSeleccionadoM.isSelected() && !VIPSeleccionadoM.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe pulsar una opción en las entradas");
            alert.showAndWait();

            throw new RuntimeException("");
        } else if(NormalSeleccionadoM.isSelected()){
            precio=(entradas*10);

        }else if(VIPSeleccionadoM.isSelected()){
            precio=(entradas*15);
        }
        precioFinal = precio + "";
        TextoTotalM.setText(precioFinal+"€");
    }

    @FXML
    void PulsarBotonEnviarM(ActionEvent event) {
        String correo="";
        String fila="";
        String asientos="";
        if (choiceboxUbicacionM.getValue()==null) {
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

        if (EscribirFilaM.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe seleccionar una opción en Fila");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            fila = EscribirFilaM.getText();
        }
        if (EscribirAsientosM.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe seleccionar una opción en Asientos");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            asientos = EscribirAsientosM.getText();
        }

        if (PonerCorreoM.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en datos");
            alert.setContentText("Debe seleccionar una opción en Correo");
            alert.showAndWait();
            //Aquí decimos que, una vez que de el error, pare el programa hasta que no se seleeccione
            //esta opción, para que el programa no siga
            throw new RuntimeException("");

        } else {
            correo = PonerCorreoM.getText();
        }
        if (TextoTotalM.getText().isEmpty()) {
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
        alert.setContentText("Se le enviará una factura a: \nCorreo: "+correo+ "\nCon la siguinete información"+ " \nUbicación: "+choiceboxUbicacionM.getValue()+" \nFila: "+fila+ " \nAsientos: "+asientos+ " \nPrecio: "+precioFinal+"€"+"\nPartido: Miami-Celtics");
        alert.showAndWait();
    }

    @FXML
    void PulsarBotonVolverM(ActionEvent event) {
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
        choiceboxUbicacionM.getItems().addAll(Ubicacion);
    }
}
