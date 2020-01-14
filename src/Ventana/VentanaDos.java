package Ventana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class VentanaDos extends Stage {

    public VentanaDos(String titulo) {
        initGUI();
    }

    private void initGUI() {
        Stage ventadaAdicional= new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../layout/layoutVentadaDos.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root,300,300);
        ventadaAdicional.setScene(scene);
        ventadaAdicional.setTitle("Adicional");
        ventadaAdicional.initStyle(StageStyle.TRANSPARENT);
        ventadaAdicional.show();
    }
}
