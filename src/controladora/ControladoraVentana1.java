package controladora;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import utils.Persona;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraVentana1 implements Initializable {

    DropShadow sombra = new DropShadow();
    @FXML
    Button btnNormal, btnImagen;
    @FXML
    Tab tabBotones, tabTextos;
    @FXML
    CheckBox check;

    @FXML
    RadioButton radio1, radio2, radio3;

    ToggleGroup grupoRadios;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        acciones();
        personalizarBotones();

    }

    private void instancias() {
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radio1, radio2, radio3);
    }

    private void personalizarBotones() {
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("../resources/button_ok.png")));
        btnImagen.setGraphic(imageView);
        btnImagen.setGraphic(imageView);
    }

    private void acciones() {
        btnNormal.setOnMouseEntered(new manejoRaton());
        btnImagen.setOnMousePressed(new manejoRaton());
        btnNormal.setOnMouseExited(new manejoRaton());
        btnImagen.setOnMouseReleased(new manejoRaton());
    check.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if(newValue){
                btnNormal.setDisable(true);
            }else{
                btnNormal.setDisable(false);
            }
        }
    });
        btnNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(check.isSelected());
                //gruporadios.getSelectedToggle();
                grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                    @Override
                    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                        Persona seleccionado = (Persona) newValue.getUserData();
                        System.out.println(seleccionado.getEstado());
                    }
                });
            }
        });


    }

    class manejoRaton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            if (event.getSource() == btnNormal) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    btnNormal.setEffect(sombra);

                } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                    btnNormal.setEffect(null);
                }
            } else if (event.getSource() == btnImagen) {
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    btnImagen.setEffect(sombra);
                } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    btnImagen.setEffect(null);
                }
            }
        }
    }

}
