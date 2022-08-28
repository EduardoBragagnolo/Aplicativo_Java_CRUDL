# Aplicativo_Java_CRUDL

Projeto de software desenvolvido em Java, utilizando o CRUDL para escrita no banco de dados.

Para desenvolvimento foram usados Netbeans para desenvolvimento do código, MySQL Workbench para o banco de dados e o Gluon Scene Builder para as interfaces.

# Pré-requisitos:

* IDE da sua preferência;
* Software para banco de dados
* Software para desenolver a interface.

# Criando a tela inicial:

package com.mycompany.zcondo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class TelaInicialController  {
  
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    MenuButton sindico;

    @FXML
    private void agenda(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("agenda" + ".fxml")).load();

        rootPane.getChildren().add(newLoadedPane);
        

    }

    @FXML
    private void fornecedores(ActionEvent event) throws IOException {
       
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("fornecedores" + ".fxml")).load();    

        rootPane.getChildren().add(newLoadedPane);
        
    }

    @FXML
    private void notificacoes(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("notificacoes" + ".fxml")).load();    

        rootPane.getChildren().add(newLoadedPane);
        
    }

    @FXML
    private void espacos(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("espacos" + ".fxml")).load();  //Sem tela ainda

        rootPane.getChildren().add(newLoadedPane);
        
    }
    
    @FXML
    private void financeiro(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("financeiro" + ".fxml")).load();  //Sem tela ainda

        rootPane.getChildren().add(newLoadedPane);
        
    }
        
    @FXML
    private void CadastroMoradores(ActionEvent event) throws IOException {
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("moradores" + ".fxml")).load();  

        rootPane.getChildren().add(newLoadedPane);
    }
    
    @FXML
    private void CadastroFornecedores(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("fornecedores" + ".fxml")).load();  

        rootPane.getChildren().add(newLoadedPane);
        
    }
    
    @FXML
    private void UpdateNotificacoes(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("notificacoes" + ".fxml")).load();  

        rootPane.getChildren().add(newLoadedPane);
        
    }
    
    @FXML
    private void moradores(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("moradores" + ".fxml")).load();

        rootPane.getChildren().add(newLoadedPane);
        
    }
    
    @FXML
    private void sair(ActionEvent event) throws IOException {
        
        App.closeCurrentWindow();
              
    }
}
