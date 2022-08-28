package com.mycompany.zcondo;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FornecedoresController implements Initializable {
    
    static Fornecedores cadastrofornecedores;
    
    @FXML
    private TableView <Fornecedores> fornecedoresTabela;
    
    @FXML
    private TableColumn <Fornecedores, String> nomeFornecedorColumn;
    
    @FXML
    private TableColumn <Fornecedores, String> telefoneFornecedorColumn;
    
    @FXML
    private TableColumn <Fornecedores, String> categoriaFornecedorColumn;
    
    @FXML
    private TableColumn <Fornecedores, String> precoFornecedorColumn;  
    
    static ObservableList <Fornecedores> cadastroFornecedores;
    
    @Override
    public void initialize (URL url,ResourceBundle rb){
        
        this.nomeFornecedorColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.telefoneFornecedorColumn.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        this.categoriaFornecedorColumn.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        this.precoFornecedorColumn.setCellValueFactory(new PropertyValueFactory<>("preco"));        
        
        this.cadastroFornecedores = this.fornecedoresTabela.getItems();
        
        FornecedoresDAO daoDoFornecedor = new FornecedoresDAO();
        List <Fornecedores> fornecedorNoBanco = daoDoFornecedor.getAll();
        
        this.cadastroFornecedores.addAll(fornecedorNoBanco);
        
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
        
        App.setRoot("telaInicial");

    }
    
    @FXML
    void novoFornecedor(ActionEvent event) throws IOException {
        
        CadastroDeFornecedoresController.setFornecedores(null);
        
        App.showModal("cadastroDeFornecedores");
        
        Fornecedores novoFornecedor = CadastroDeFornecedoresController.getFornecedores();
        if (novoFornecedor != null){
            this.cadastroFornecedores.add(novoFornecedor);

            
        }    
    }
    
    @FXML
    void remover() throws IOException{
        
        Fornecedores fornecedorSelecionado = this.fornecedoresTabela.getSelectionModel().getSelectedItem();
        
        // Confirmação de remoção
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remoção");
        alert.setHeaderText("Deseja remover " + fornecedorSelecionado.getNome());
        alert.setContentText("Deseja remover o fornecedor?");

        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK){
            
            this.cadastroFornecedores.remove(fornecedorSelecionado);
            
            FornecedoresDAO daoDoFornecedor = new FornecedoresDAO();
            daoDoFornecedor.delete(fornecedorSelecionado);
        
        }     
    } 
    
    @FXML
    void editar() throws IOException {
        
        Fornecedores fornecedorSelecionado = this.fornecedoresTabela.getSelectionModel().getSelectedItem();
        
        if (fornecedorSelecionado != null) {
            CadastroDeFornecedoresController.setFornecedores(fornecedorSelecionado)  ;
            
            App.showModal("cadastroDeFornecedores");  //EXECUÇÃO PARA E SÓ CONTINUA QUANDO EU FECHAR O MODAL
            
            Fornecedores fornecedorAlterado = CadastroDeFornecedoresController.getFornecedores();
            
            fornecedorSelecionado.setNome (fornecedorAlterado.getNome());
            fornecedorSelecionado.setTelefone (fornecedorAlterado.getTelefone());
            fornecedorSelecionado.setCategoria (fornecedorAlterado.getCategoria());
            fornecedorSelecionado.setPreco (fornecedorAlterado.getPreco());
            
            this.fornecedoresTabela.refresh ();
            
            FornecedoresDAO daoDoFornecedor = new FornecedoresDAO();
            daoDoFornecedor.update(fornecedorAlterado);
            
        }
    }
}