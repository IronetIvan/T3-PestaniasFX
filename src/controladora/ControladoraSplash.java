package controladora;

import Ventana.VentanaUno;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraSplash implements Initializable {

    @FXML
    ImageView imagenFondo;
    @FXML
    ProgressBar progreso;

    Task tareaSecundaria;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();

        progreso.progressProperty().bind(tareaSecundaria.progressProperty());

        FadeTransition transicion = new FadeTransition(Duration.seconds(3), imagenFondo);
        transicion.setToValue(1.0);
        transicion.setFromValue(0.0);
        transicion.play();

        transicion.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                new Thread(tareaSecundaria).start();
            }
        });
        tareaSecundaria.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                VentanaUno ventanaUno = new VentanaUno();
                Stage stage = (Stage) imagenFondo.getScene().getWindow();
                stage.close();//or hide()

            }
        });
        /*progreso.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue.intValue());
            }
        });*/

    }

    private void instancias() {
        tareaSecundaria = new Task() {
            @Override
            protected Object call() throws Exception {

                for(int i = 0; i<100; i++){
                    updateProgress(i,100);
                    Thread.sleep(100);
                }

                return null;
            }
        };
    }


}
