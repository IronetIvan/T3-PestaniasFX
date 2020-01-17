package Ventana;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class VentanaDos extends Stage {
    String titulo = null;
    public VentanaDos(String titulo) {

        this.titulo = titulo;
        initGUI();
    }

    private void initGUI() {
        Stage ventadaAdicional= new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../layout/VentanaDosSceneUno.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root,300,300);
        ventadaAdicional.setScene(scene);
        ventadaAdicional.setTitle(titulo);
        ventadaAdicional.initStyle(StageStyle.DECORATED);
        ventadaAdicional.show();
    }
}
