package com.mycompany.zcondo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadastroDeMoradoresController implements Initializable{
    
    static Moradores novoMorador;

    @FXML
    TextField nomeTextField;
    
    @FXML
    DatePicker dataDeNascimentoDatePicker;     
    
    @FXML
    TextField cpfTextField;
    
    @FXML
    TextField rgTextField;
    
    @FXML
    TextField apartamentoTextField;
    
    @FXML
    TextField telefoneTextfield;
    
    @FXML
    TextField emailTextField;

     /**
     * Método executado todas as vezes que a tela é aberta, antes de qualquer
     * outro método.
     */
    
    @Override
    public void initialize (URL url, ResourceBundle rb) {
        
        /*
        Preenche os campos da tela caso a variável que contém o produto
        não seja nula.
        */
        
        if (novoMorador != null){      
            
            nomeTextField.setText(novoMorador.getNome());
            dataDeNascimentoDatePicker.setUserData(novoMorador.getDataDeNascimento());
            cpfTextField.setText(novoMorador.getCpf());
            rgTextField.setText(novoMorador.getRg());
            apartamentoTextField.setText(novoMorador.getApartamento());
            telefoneTextfield.setText(novoMorador.getTelefone());
            emailTextField.setText(novoMorador.getEmail());
            
        }
    }
   
    static Moradores getMoradores(){
        
        return novoMorador;
        
    }
    
    static void setMoradores (Moradores cadastromoradores){
        
        CadastroDeMoradoresController.novoMorador = cadastromoradores;
        
    }
    
    @FXML
    void btnSalvar() {
        
        if(!this.nomeTextField.getText().isEmpty()//
                && !this.cpfTextField.getText().isEmpty()//
                    && !this.rgTextField.getText().isEmpty()
                        && !this.apartamentoTextField.getText().isEmpty()//
                            && !this.telefoneTextfield.getText().isEmpty()//
                                && !this.emailTextField.getText().isEmpty()){
            
        Moradores novoMorador = new Moradores (
                
                this.nomeTextField.getText(),
                this.dataDeNascimentoDatePicker.getValue().toString(),
                this.cpfTextField.getText(),
                this.rgTextField.getText(),
                this.apartamentoTextField.getText(),
                this.telefoneTextfield.getText(),
                this.emailTextField.getText(),
                2  //nivel de condômino
        );
        
        MoradorDAO moradorDAO = new MoradorDAO();
        
        moradorDAO.save(novoMorador); //Salvando o produto no banco
        MoradoresController.cadastroMoradores.add(novoMorador);
    

        App.closeCurrentWindow();
        
        }
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
        
        App.setRoot("telaInicial");

    }
}