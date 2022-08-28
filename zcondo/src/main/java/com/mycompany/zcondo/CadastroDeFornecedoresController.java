package com.mycompany.zcondo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class CadastroDeFornecedoresController {
   
    static Fornecedores novoFornecedor;
    
    @FXML
    TextField nomeTextField;
    
    @FXML
    TextField categoriaTextField;      
    
    @FXML
    TextField CPFTextField;
    
    @FXML
    TextField RGTextField;
    
    @FXML
    TextField precoTextField;
    
    @FXML
    TextField telefoneTextfield;
    
    @FXML
    TextField emailTextField;  
    
    @FXML
    public void initialize(URL url, ResourceBundle rb){
        
        if (novoFornecedor != null){
          
            nomeTextField.setText(novoFornecedor.getNome());
            categoriaTextField.setText(novoFornecedor.getCategoria());
            CPFTextField.setText(novoFornecedor.getCpf());
            RGTextField.setText(novoFornecedor.getRg());
            precoTextField.setText(Double.toString(novoFornecedor.getPreco()));
            telefoneTextfield.setText(novoFornecedor.getTelefone());
            emailTextField.setText(novoFornecedor.getEmail());
            
        }
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
        
        App.setRoot("telaInicial");
        

    }
    
    static Fornecedores getFornecedores (){
        
        return novoFornecedor;
        
    }

    static void setFornecedores (Fornecedores cadastrofornecedores){
        
        CadastroDeFornecedoresController.novoFornecedor = cadastrofornecedores;
        
    }
    
    @FXML
    void btnSalvar(ActionEvent event) {
        
        if(!this.nomeTextField.getText().isEmpty()//
                && !this.CPFTextField.getText().isEmpty()//
                    && !this.categoriaTextField.getText().isEmpty()   
                        && !this.RGTextField.getText().isEmpty()
                            && !this.precoTextField.getText().isEmpty()//
                                && !this.telefoneTextfield.getText().isEmpty()//
                                    && !this.emailTextField.getText().isEmpty()){
            
            Fornecedores novoFornecedor = new Fornecedores (
                
                this.nomeTextField.getText(),
                this.categoriaTextField.getText(),
                this.CPFTextField.getText(),
                this.RGTextField.getText(),
                Double.parseDouble(this.precoTextField.getText()),
                this.telefoneTextfield.getText(),
                this.emailTextField.getText());
            
            FornecedoresDAO daoDoFornecedor = new FornecedoresDAO();
            daoDoFornecedor.save(novoFornecedor);
            FornecedoresController.cadastroFornecedores.add(novoFornecedor);
            
            App.closeCurrentWindow();
        
        }
    }        
}