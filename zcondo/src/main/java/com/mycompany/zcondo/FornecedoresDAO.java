
package com.mycompany.zcondo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FornecedoresDAO {
    
    public List<Fornecedores> getAll() {
        
        try {
            
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoFornecedores = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM fornecedor");
            
            List<Fornecedores> resultadoComTodosFornecedores = new ArrayList<>();

            while (!resultadoFornecedores.isLast()) {
                resultadoFornecedores.next();
                
                String nomeFornecedor = resultadoFornecedores.getString("nomeFornecedor");
                String categoriaFornecedor = resultadoFornecedores.getString("categoriaFornecedor");
                String cpfFornecedor = resultadoFornecedores.getString("cpfFornecedor");
                String rgFornecedor = resultadoFornecedores.getString("rgFornecedor");
                double precoFornecedor = resultadoFornecedores.getDouble("precoFornecedor");
                String telefoneFornecedor = resultadoFornecedores.getString("telefoneFornecedor");
                String emailFornecedor = resultadoFornecedores.getString("emailFornecedor");
                
                
                Fornecedores fornecedorQuePegueiDoBanco = new Fornecedores(nomeFornecedor, categoriaFornecedor , cpfFornecedor , rgFornecedor , precoFornecedor , telefoneFornecedor , emailFornecedor);
                resultadoComTodosFornecedores.add(fornecedorQuePegueiDoBanco);
            }
            
            return resultadoComTodosFornecedores;
            
        } catch (Exception e) {
            
            throw new RuntimeException(e);
            
        }
    }

    public void save(Fornecedores novoFornecedor) {
        
        try {
            
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("INSERT INTO fornecedor values (" //
                            + " '" + novoFornecedor.nome + "'" //
                                + ", '" + novoFornecedor.categoria + "'" //
                                    + ", '" + novoFornecedor.cpf + "'" //
                                        + ", '" + novoFornecedor.rg + "'" //
                                            + ", " + novoFornecedor.preco //   
                                                + ", '" + novoFornecedor.telefone + "'" //
                                                    + ", '" + novoFornecedor.email + "'" + ")");
        
        } catch (Exception e) {
            
            throw new RuntimeException(e);
            
        }
    }
    
    public void update(Fornecedores fornecedorEditado) {
        
        try {
            
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("UPDATE fornecedor SET " //
                            + "nomeFornecedor = '" + fornecedorEditado.nome + "'" //
                                + ",categoriaFornecedor = " + fornecedorEditado.categoria //
                                    + ", cpfFornecedor = " + fornecedorEditado.cpf //
                                        + ", precoFornecedor = " + fornecedorEditado.preco //
                                            + ", telefoneFornecedor = " + fornecedorEditado.telefone //
                                                + ", emailFornecedor = " + fornecedorEditado.email //
                                                    + " WHERE rgFornecedor = " + fornecedorEditado.rg //
                    ); 
            
        } catch (Exception e) {
            
            throw new RuntimeException(e);
            
        }
    }
    
    public void delete(Fornecedores fornecedorParaRemover) {
       
        try {
            
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("DELETE FROM fornecedor where rgFornecedor = '" + fornecedorParaRemover.rg + "'");
        
        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }    
    }
}