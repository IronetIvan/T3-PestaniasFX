package controladora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraVentanaDosSceneUno implements Initializable {

    @FXML
    Button btnDos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnDos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //System.out.println("Pulsado");
                Stage stage = (Stage) btnDos.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("../layout//VentanaDosSceneUno.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root,stage.getWidth(),stage.getHeight());
                stage.setScene(scene);
            }
        });

    }
}
