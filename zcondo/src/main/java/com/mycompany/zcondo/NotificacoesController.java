package com.mycompany.zcondo;

import java.io.IOException;
import java.net.URL;
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

public class NotificacoesController implements Initializable {
    
    static Notificacao notificacao;
    
    @FXML
    private TableView<Notificacao> notificacaoTabela;
     
    @FXML
    private TableColumn<Notificacao, String> moradorNotificacaoColumn;
    
    @FXML
    private TableColumn<Notificacao, String> mensagemNotificacaoColumn;      //Declaração da tabela
    
    @FXML
    private TableColumn<Notificacao, String> dataNotificacaoColumn;
     
    static ObservableList<Notificacao> notificacoes;
     
    @Override
    public void initialize (URL url,ResourceBundle rb){
        
        this.moradorNotificacaoColumn.setCellValueFactory(new PropertyValueFactory<>("emissor"));
        this.mensagemNotificacaoColumn.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        this.dataNotificacaoColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
 
        NotificacoesController.notificacoes = this.notificacaoTabela.getItems();
         
                
        NotificacaoDAO notificaDAO = new NotificacaoDAO();
        
//        notificaDAO.save();
//        NotificacoesController.cadastroNotificacoes.add(novaNotificacao);
//        App.closeCurrentWindow();
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
       
        App.setRoot("telaInicial");
        
    }
    
    
    @FXML
    void remover() throws IOException{
        
        Notificacao notificacaoSelecionada = this.notificacaoTabela.getSelectionModel().getSelectedItem();
        
        // Confirmação de remoção
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remoção");
        alert.setHeaderText(notificacaoSelecionada.getEmissor() + "/n " + notificacaoSelecionada.getDescricao());
        alert.setContentText("Deseja remover a notificação?");

        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK){
            
            this.notificacoes.remove(notificacaoSelecionada);
            
            NotificacaoDAO daoDaNotificacao = new NotificacaoDAO();
            daoDaNotificacao.delete(notificacaoSelecionada);
        }       
    }
    
    @FXML
    void editar() throws IOException {
       
        Notificacao notificacaoSelecionada = this.notificacaoTabela.getSelectionModel().getSelectedItem();
        
        if (notificacaoSelecionada != null) {
            NovaNotificacaoController.setNotificacao(notificacaoSelecionada)  ;
            
            App.showModal("novaNotificacao");  //EXECUÇÃO PARA E SÓ CONTINUA QUANDO EU FECHAR O MODAL
            
            Notificacao notificacaoAlterada = NovaNotificacaoController.getNotificacao();
            
            notificacaoSelecionada.setEmissor (notificacaoAlterada.getEmissor());
            notificacaoSelecionada.setDescricao (notificacaoAlterada.getDescricao());
            
            this.notificacaoTabela.refresh();
        }
    }
    
    @FXML
    void novaNotificacao(ActionEvent event) throws IOException {
        
        App.showModal("novaNotificacao");
        
    } 
}