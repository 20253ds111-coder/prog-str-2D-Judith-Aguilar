package com.example.loginanddashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML private Label botonDeBienvenida;
    @FXML  private TextField nombreUsuario;
    @FXML private TextField correoUsuario;
    @FXML  private PasswordField passUsuario;

    @FXML
    protected void procesoEnviar(ActionEvent event) throws IOException{
        String correo = correoUsuario.getText();
        String pass = passUsuario.getText();
        String nombre = nombreUsuario.getText();

        if (!correo.isEmpty() && !pass.isEmpty() && !nombre.isEmpty()){
            if (correo.contains("@") && correo.contains(".")){
                if (nombre.length() > 3){
                    if (pass.length() >= 6){
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("perfil-view.fxml"));
                        Parent root = loader.load();
                        PerfilController perfilCtrl = loader.getController();
                        perfilCtrl.setDatosUsuario(nombre);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }else {
                        botonDeBienvenida.setText("Contraseña muy corta (minimo 6)");
                    }
                }else {
                    botonDeBienvenida.setText("rango de nombre no valido (mayor a 4)");
                }
            }else {
                botonDeBienvenida.setText("correo no valido (necesita @ y .)");
            }
        }else {
            botonDeBienvenida.setText("No puede haber campos vacios");
        }
    }
}
