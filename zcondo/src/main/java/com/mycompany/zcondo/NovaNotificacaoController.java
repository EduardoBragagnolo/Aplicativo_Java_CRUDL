package com.mycompany.zcondo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;



public class NovaNotificacaoController implements Initializable {
    
    static Notificacao notificacao;
    
    Notificacao notificacaoTeste = new Notificacao ("eqqgrqg", "wggregqegr","hoje" );
    
    
    @FXML
    TextField mensagemTextField;
    
    @FXML
    TextField moradorTextField;
    
    @FXML
    DatePicker dataDataPicker;
    
    @Override
    public void initialize (URL url, ResourceBundle rb) {
        
        if (notificacao != null){      
            
            mensagemTextField.setText(notificacao.getDescricao());
            moradorTextField.setText(notificacao.getEmissor());
            
        }
    }
  
    static Notificacao getNotificacao() {                             //Getter
        
        return notificacao;
        
    }

    static void setNotificacao(Notificacao notificacao) {                //Setter
       
        NovaNotificacaoController.notificacao = notificacao;
       
    }
      
    @FXML
    void salvar(){
        
        if (!this.mensagemTextField.getText().isEmpty() //
                && !this.moradorTextField.getText().isEmpty()){             //Salvar
             
        notificacao = new Notificacao(
            
                this.mensagemTextField.getText(),
            this.moradorTextField.getText(),
            this.dataDataPicker.getValue().toString());
            
        
        NotificacoesController.notificacoes.add(notificacao);
        App.closeCurrentWindow();
        
        }
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
        
        App.setRoot("telaInicial");
        
    }
}