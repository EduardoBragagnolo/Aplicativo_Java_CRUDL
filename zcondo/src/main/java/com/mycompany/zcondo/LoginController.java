package com.mycompany.zcondo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    
    @FXML
    TextField usuarioTextField;
    
    @FXML
    PasswordField senhaPasswordField;
    
    @Override
    public void initialize (URL url,ResourceBundle rb){
        
    }
    
    @FXML
    void login() throws IOException{
        MoradorDAO dao = new MoradorDAO();
        Moradores usuarioLogin = new Moradores (usuarioTextField.getText(), senhaPasswordField.getText());      //Construtor usado no objeto Morador
        boolean usuarioExiste = dao.exists(usuarioLogin);

        if (usuarioExiste) {
            /*
            Caso o usuário exista leva para a tela principal
            */
            Stage stage = (Stage) this.usuarioTextField.getScene().getWindow();
            stage.setMaximized(true);
            stage.setResizable(true);

            App.setRoot("telaInicial");
        }else{
            
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Usuario ou senha incorreta! ");
            alert.setContentText("Tente novamente");

            alert.showAndWait();
            
        }
    }

    @FXML
    public void onUserTyped() {
        //System.out.println("Tecla digitada no campo usuário");
    }
    
}