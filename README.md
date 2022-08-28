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
![Screenshot_2](https://user-images.githubusercontent.com/108675590/187092688-22fe6d96-7d82-4b1e-9d30-52e2b39a9499.png)

# Criando a conexão com o banco de dados:


package com.mycompany.zcondo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
        
public class ConnectionSingleton {
    
    private static Connection connection;
    
    static Connection getConnection() throws SQLException {
        
        if (connection == null){
            
            connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/mydb","root","root");
        }  
        return connection;
   
    }
    
}
