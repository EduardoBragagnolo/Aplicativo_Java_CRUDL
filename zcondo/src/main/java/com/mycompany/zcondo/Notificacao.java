package com.mycompany.zcondo;

import java.util.Calendar;

public class Notificacao {
    
    public String dia; 
    public String mes;
    public String ano; 
    
    public String hora;                           //Atributos
    public String minuto;
    
    public String data;
    
    public String descricao;
    
    public String emissor;
    
    public int classificacao;
    
    

    public Notificacao(String descricao, String emissor, String data) {

        this.data = data; //data
        
        this.descricao = descricao;   //Mensagem

        this.emissor = emissor;   //EMissor

        this.classificacao = 0;    //Classificacao
        
    }
 
    public String getDescricao() {
        
        return descricao;
        
    }

    public String getEmissor() {
        
        return emissor;
        
    }

    public void setDescricao(String descricao) {
        
        this.descricao = descricao;
        
    }

    public void setEmissor(String emissor) {
        
        this.emissor = emissor;
        
    }

    public void setData(String data) {
        
        this.data = data;
        
    }

    public String getData() {
        
        return data;
        
    }      
}