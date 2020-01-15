package controladora;

import Ventana.VentanaUno;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraSplash implements Initializable {

    @FXML
    ImageView imagenFondo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FadeTransition transicion = new FadeTransition(Duration.seconds(3), imagenFondo);
        transicion.setToValue(1.0);
        transicion.setFromValue(0.0);
        transicion.play();

        transicion.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaUno ventanaUno = new VentanaUno();
                Stage stage = (Stage) imagenFondo.getScene().getWindow();
                stage.close();
            }
        });

    }
}
